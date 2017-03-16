package core.admin.service.impl;

import com.google.common.base.Strings;
import core.admin.common.SendSMSMessageUtil;
import core.admin.common.constants.exception.AppException;
import core.admin.common.page.Page;
import core.admin.dao.MenuMapper;
import core.admin.dao.UserMapper;
import core.admin.domain.NetworkUser;
import core.admin.exception.ServiceDataException;
import core.admin.service.UserService;
import core.admin.util.AES;
import core.admin.util.CipherUtils;
import core.admin.util.SessionUtils;
import core.admin.util.UserUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import core.admin.common.ErrorCode;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.admin.common.AdminConstants.*;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userDao;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public NetworkUser login(HttpServletRequest request, String mobile, String password) {
        NetworkUser adminUser = userDao.getUserByCredential(mobile, DigestUtils.md5Hex(password));

        if (adminUser != null) {
//            AdminUser sessionAdminUser = SessionUtils.getSessionValue(request,SESSION_USER_KEY);
            if ( USER_STATUS_NORMAL == adminUser.getStatus()) {
                SessionUtils.setSession(request, SESSION_USER_KEY, adminUser);
            }
            return adminUser;
        }

        return null;
    }

    @Override
    public Page<NetworkUser> findNetworkUserList(int currentPage, Integer pageSize, Map<String, Object> search) {
       /* PaginatedPage<NetworkUser> paginatedPage = PaginatedPage.create(page);
        paginatedPage.setCount(userDao.countAdminUserList(status));
        paginatedPage.setDatum(new PaginatedPage.PaginatedCallback<NetworkUser>() {
            @Override
            public List<NetworkUser> execute(Integer offset, Integer limit) {
                return userDao.findAdminUserList(status, offset, limit);
            }
        });*/
        Page<NetworkUser> page = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderField", "u.id");
        params.put("orderFieldType", "desc");

        if(search!=null && search.size()>0){
            params.putAll(search);
        }

        try {
            //设置页数。
            page = new Page<NetworkUser>(currentPage, pageSize);
            Integer count = userDao.countAdminUserList();
            if (count == null || count <= 0) {
                return page;
            }
            page.setTotalCount(count);
            params.put("startIndex", page.getStartIndex());
            params.put("pageSize", page.getPageSize());
            page.setResult(userDao.findAdminUserList(params));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return page;
    }

    @Override
    public Integer resetPassword(Long id,String newPassword) {
        Long now = DateTime.now().getMillis();
        return userDao.resetPassword(id, CipherUtils.md5(newPassword),now);
    }

    @Override
    public Integer updateStatus(Integer id, Integer status) {
        Long now = DateTime.now().getMillis();
        return userDao.updateStatus(id, status, now);
    }

    public Integer removeNetworkUser(Long id){
        return userDao.removeNetworkUser(id);
    }

    @Override
    public NetworkUser queryAdminUserById(Long id) {

        NetworkUser user = null;
        try {
            user = userDao.selectById(id);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return user;
    }

    @Override
    public NetworkUser createUser(NetworkUser user) {

        Long now = DateTime.now().getMillis();
        if (user != null) {
            if (user.getId() != null && user.getId() != 0) {
                user.setUpdateTime(now);
                if(StringUtils.isNotEmpty(user.getPassword()))
                    user.setPassword( CipherUtils.md5(user.getPassword()));
                userDao.update(user);
                return user;
            } else {
                if(StringUtils.isNotEmpty(user.getPassword()))
                    user.setPassword( CipherUtils.md5(user.getPassword()));
                user.setCreateTime(now);
                userDao.createUser(user);
                return user;
            }
        }else{
            return user;
        }
    }

    @Override
    public Integer findUserByMobile(String mobile) {
        Integer num = userDao.getUserByMobile(mobile);
        return num;
    }



    @Override
    public String login(String mobile, String pwd) {
        NetworkUser user = userDao.getUserByCredential(mobile, DigestUtils.md5Hex(pwd));
        if (user == null) {
            long now = DateTime.now().getMillis();

            logger.debug("new user!");

            return null;
        } else {
            Integer status = user.getStatus();

            logger.debug("user exist:status:{}",status);

            if (status != 1) {
                throw new ServiceDataException(ErrorCode.ERR_USER_DISABLE);
            }

//            try {
//                AdminUser userLocal = LoginInterceptor.get();
//                if (userLocal != null) {
//                    logger.error("user login duplicate!");
//                    throw new ServiceDataException(ERR_USER_LOGIN_ALREADY_ERROR);
//                }
//            } catch (ServiceDataException e) {
//                // no-op
//            }

            logger.debug("exist user!");
        }


        String token = generateToken(String.valueOf(user.getId()));

        logger.debug("user login successfully!");

        return token;
    }

    public String loginBySmsCode(String mobile, String smsCode) {
        String key = String.format("%s%s", SMS_CODE_PREFIX, mobile);
        String smsCodeBack = UserUtils.CODES.getIfPresent(key);

        if (Strings.isNullOrEmpty(mobile) ||
                !MOBILE_CHINESE_PATTERN.matcher(mobile).matches()){
            throw new ServiceDataException(ErrorCode.ERR_USER_MOBILE_ERROR);
        }

        if (Strings.isNullOrEmpty(smsCode)
                || !smsCode.equalsIgnoreCase(smsCodeBack)) {
            throw new ServiceDataException(ErrorCode.ERR_USER_SMS_CODE_ERROR);
        }


        Integer length = mobile.length();
        String mobileLocal = mobile.substring(length - 11);
        //NetworkUser user = userDao.getUserByMobile(mobileLocal);
        if (user == null) {
            long now = DateTime.now().getMillis();
//            userDao.saveUser(mobileLocal, now);
            //  user = userDao.getUserByMobile(mobileLocal);
            logger.debug("new user!");
        } else {
            Integer status = user.getStatus();

            logger.debug("user exist:status:{}",status);

            if (status != 1) {
                throw new ServiceDataException(ErrorCode.ERR_USER_DISABLE);
            }
        }


        String token = generateToken(String.valueOf(user.getId()));

        logger.debug("user login successfully!");

        return token;
    }


    public boolean modfiyPwd(String mobile,String newPwd, String smsCode,Long uId) {
        String key = String.format("%s%s", SMS_CODE_PREFIX, mobile);
        String smsCodeBack = UserUtils.CODES.getIfPresent(key);

        if (Strings.isNullOrEmpty(mobile) ||
                !MOBILE_CHINESE_PATTERN.matcher(mobile).matches()){
            throw new ServiceDataException(ErrorCode.ERR_USER_MOBILE_ERROR);
        }

        if (Strings.isNullOrEmpty(smsCode)
                || !smsCode.equalsIgnoreCase(smsCodeBack)) {
            throw new ServiceDataException(ErrorCode.ERR_USER_SMS_CODE_ERROR);
        }


        Integer length = mobile.length();
        String mobileLocal = mobile.substring(length - 11);
        NetworkUser user = userDao.selectById(uId);
        if (user != null) {
            user.setUpdateTime(System.currentTimeMillis());
            if(StringUtils.isNotEmpty(user.getPassword()))
                user.setPassword( CipherUtils.md5(newPwd));
            userDao.update(user);
            logger.debug("update user success!");

        }
        return true;

    }

    @Override
    public String getTokenByUid(Integer uId) {

        NetworkUser user = userDao.selectById(Long.valueOf(uId));
        if (user != null) {

            Integer status = user.getStatus();

            logger.debug("user exist:status:{}",status);

            if (status != 1) {
                throw new ServiceDataException(ErrorCode.ERR_USER_DISABLE);
            }

            logger.debug("exist user!");
        }
        String token = generateToken(String.valueOf(user.getId()));

        logger.debug("user login successfully!");

        return token;
    }

    private String generateToken(String uid) {
        try {
            return AES.encrypt(uid);
        } catch (Exception e) {
            logger.error("user token error!",e);
            throw new ServiceDataException(ErrorCode.ERR_USER_TOKEN_GENERATE_ERROR);
        }
    }

    public String getVerifyCode(String mobile) {
        // 访问规则控制
        String smsCode = RandomStringUtils.randomNumeric(4);
//        String smsCode = "7700";

        String key = String.format("%s%s", SMS_CODE_PREFIX,mobile);
        UserUtils.CODES.put(key, smsCode);

        StringBuilder sb = new StringBuilder(32);
        sb.append("验证码:");
        sb.append(smsCode);
        sb.append(",");
        sb.append("5分钟内使用有效");
        SendSMSMessageUtil.sendSmsByMeiLian(mobile, sb.toString());
        return smsCode;
    }
}
