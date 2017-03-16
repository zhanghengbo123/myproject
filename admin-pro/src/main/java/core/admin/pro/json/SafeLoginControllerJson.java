package core.admin.pro.json;

import core.admin.domain.Menu;
import core.admin.domain.NetworkUser;
import core.admin.domain.NetworkUser;
import core.admin.domain.Role;
import core.admin.pro.common.Result;
import core.admin.pro.common.ResultCode;
import core.admin.pro.service.cache.LoginCacheService;
import core.admin.pro.service.login.LoginService;
import core.admin.pro.service.shiro.ShiroUserService;
import core.admin.pro.util.ManagerLogin;
import core.admin.pro.util.NetworkUtil;
import core.admin.service.MenuService;
import core.admin.service.RoleService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by chenshaofeng1996 on 2016/8/30.
 */

@Controller
@RequestMapping(value = "/user")
public class SafeLoginControllerJson {

    @Resource
    private LoginService loginService;
    private static Logger logger =LoggerFactory.getLogger(SafeLoginControllerJson.class);
    @Resource
    private ShiroUserService shiroUserService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;


    @ResponseBody
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Result login(@RequestBody LoginUser user, HttpServletRequest request, HttpServletResponse response){
        Subject subject= SecurityUtils.getSubject();
        System.out.println(user.toString());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), DigestUtils.md5Hex(user.getPassword()));
        try{

            subject.login(token);
            //获取http中hear的连接类型。互联网客户端：pc；手机：app;微信：wx;
            String client_type = request.getHeader("Client-Type");
            ManagerLogin.getManagerUserInfo().getUsername();
            String webIP = NetworkUtil.getIpAddress(request);
            String newToken = UUID.randomUUID().toString();
            //获取请求的地址
            //zijikankan
            NetworkUser u = shiroUserService.getByUserName(user.getUsername());
            String userID  = u.getId() + ":" + u.getMobile()+":"+u.getUsername();

            //获取用户的对应的Token
            String[] result= loginService.getUserLoginInfo(userID,client_type);

            //判断是否有登录过
            if(result!=null) {
                //刷新用户信息
                loginService.refreshUserLoginInfo(userID, newToken, client_type);

            }else{
                //新建用户信息
                loginService.setUserLoginInfo(userID,newToken,client_type);


            }
            //更新用户对应Token信息
            loginService.setTokenInfo(userID,newToken,client_type,"",webIP,"");
            //将要的需数据以键值的对形式传到前台
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("newToken",URLEncoder.encode(newToken, "UTF-8"));
            map.put("userID",userID);
            return Result.getNew().setM("LOGIN_SUCCESS").setD(map);

            //return URLEncoder.encode(newToken, "UTF-8");
        }catch(Exception e){
            logger.error("用户登录失败",e);
            return  Result.getFailed().setC(ResultCode.SERVICE_ERROR).setM("LOGIN_FAIL");
        }
    }
}

class  LoginUser implements Serializable {
    private static final long serialVersionUID = -1212L;
    private String username;
    private String password;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginUser() {
    }

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
