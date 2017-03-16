package core.admin.pro.util;

import core.admin.domain.NetworkUser;
import core.admin.pro.json.SafeLoginControllerJson;
import core.admin.pro.service.login.LoginService;
import core.admin.pro.service.shiro.ShiroUserService;
import core.admin.pro.service.shiro.impl.ShiroUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import static core.admin.pro.service.cache.LoginCacheService.LOGIN_TOKEN_HASH;
import static core.admin.pro.service.cache.LoginCacheService.USER_ID;


public class ManagerLogin {
    private static Logger logger = LoggerFactory.getLogger(SafeLoginControllerJson.class);



    public static ManagerUserInfo getManagerUserInfo(){
        ManagerUserInfo managerUserInfo= new ManagerUserInfo ();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        LoginService inspect = ContextLoader.getCurrentWebApplicationContext().getBean(LoginService.class);
        String headerToken = request.getHeader("User-Token");
        String client_type = request.getHeader("Client-Type");
        try {
            String[] tokenInfo = inspect.getTokenInfo(headerToken, client_type);
            String userID =tokenInfo[0];

            // NetworkUser user = sus.getByUserID(Long.valueOf(userID));
            managerUserInfo.setUserID(userID);
            String[] split = userID.split(":");
            managerUserInfo.setUser_id(split[0]);
            managerUserInfo.setUsername(split[1]);
            return  managerUserInfo;
        }catch (Exception e){
            e.printStackTrace();
        }

        return managerUserInfo;
    }
    public static NetworkUser getnetworkUser(){

        NetworkUser networkUser =new NetworkUser();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ShiroUserService sus = ContextLoader.getCurrentWebApplicationContext().getBean(ShiroUserServiceImpl.class);
        try {
            String username= getManagerUserInfo().getUsername();
            networkUser = sus.getByUserName(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return networkUser;
    }
}
