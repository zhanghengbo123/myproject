package core.admin.pro.util;

import core.admin.domain.NetworkUser;
import core.admin.pro.service.cache.LoginCacheService;
import core.admin.pro.service.login.LoginService;
import core.admin.pro.service.shiro.ShiroUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserInfo {
    private static final Logger logger = LoggerFactory.getLogger(UserInfo.class);

    public static NetworkUser getUserInfo(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        LoginService inspect = ContextLoader.getCurrentWebApplicationContext().getBean(LoginService.class);
        ShiroUserService sus = ContextLoader.getCurrentWebApplicationContext().getBean(ShiroUserService.class);
        String headerToken = request.getHeader("User-Token");
        String client_type = request.getHeader("Client-Type");
        try {
            String[] tokenInfo = inspect.getTokenInfo(headerToken, client_type);
            String userID = tokenInfo[0].split(":")[0];
            NetworkUser user = sus.getByUserID(Long.valueOf(userID));
            return  user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
