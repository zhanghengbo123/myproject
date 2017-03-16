package core.admin.pro.common.interceptor;

import com.google.common.base.Strings;
import core.admin.common.ErrorCode;
import core.admin.pro.common.exception.ServiceDataException;
import core.admin.pro.common.util.AES;
import core.admin.domain.NetworkUser;
import core.admin.service.UserService;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Created by 祥龙 on 15/12/07.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private static final ThreadLocal<NetworkUser> users = new ThreadLocal<NetworkUser>();

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("pre-request:{},@:{}", request.getContextPath(), DateTime.now());

        String token = request.getHeader("token");
        if (Strings.isNullOrEmpty(token)) {
            throw new ServiceDataException(ErrorCode.ERR_USER_NOT_SIGN_ERROR);
        }

        /*ClassPathResource classPathResource = new ClassPathResource("private.key");
        File privateKeyFile = classPathResource.getFile();
        PrivateKey privateKey = PubPriKeyGen.getPrivateKey(privateKeyFile);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodeRaw = Base64.decodeBase64(token);
        byte[] plainText = cipher.doFinal(decodeRaw);
        */

        String raw = null;

        try {
            raw = AES.decrypt(token);
            logger.debug("token:{}", raw);
        } catch (Exception e) {
            logger.error("token decrypt error!",e);
            throw new ServiceDataException(ErrorCode.ERR_USER_TOKEN_ERROR);
        }

        Long uid = NumberUtils.toLong(raw);
        if (uid == 0) {
            logger.debug("token error:{}", raw);
            throw new ServiceDataException(ErrorCode.ERR_USER_NOT_SIGN_ERROR);
        }

        NetworkUser user = userService.queryAdminUserById(uid);
        users.set(user);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("post-request:{},@:{}", request.getContextPath(), DateTime.now());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        users.remove();
    }

    public static NetworkUser get(){
        NetworkUser user = users.get();
        if (user != null) {

            return user;
        }

        throw new ServiceDataException(ErrorCode.ERR_USER_NOT_SIGN_ERROR);
    }
}
