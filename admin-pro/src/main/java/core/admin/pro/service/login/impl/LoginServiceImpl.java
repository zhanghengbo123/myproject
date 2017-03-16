package core.admin.pro.service.login.impl;

import core.admin.pro.service.cache.LoginCacheService;
import core.admin.pro.service.login.LoginService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

@Component
public class LoginServiceImpl implements LoginService {


    /**
     * 默认的缓存类型
     */
    private String cacheType = "LOCAL";

    public LoginCacheService getLoginCacheService(){
        if(cacheType.equals(LoginService.CACHE_TYPE_LOCAL)){
            //LoginCacheServiceImpl  cach = new LoginCacheServiceImpl();
            return (LoginCacheService)ContextLoader.getCurrentWebApplicationContext().getBean("loginCacheService");
        }else{
           // LoginRedisServiceImpl redis   = new LoginRedisServiceImpl();
            //return  redis;
            return (LoginCacheService)ContextLoader.getCurrentWebApplicationContext().getBean("loginRedisService");
        }

    }


    @Override
    public void setUserLoginInfo(String userID, String newToken, String client_type) throws InterruptedException {
        getLoginCacheService().setUserLoginInfo(userID,  newToken,  client_type);
    }
    @Override
    public String[] getUserLoginInfo(String userID,String client_type) {
       return  getLoginCacheService().getUserLoginInfo(userID, client_type);
    }

    @Override
    public void refreshUserLoginInfo(String userID, String newToken, String client_type) {
        getLoginCacheService().refreshUserLoginInfo(userID, newToken, client_type);
    }
    @Override
    public String setTokenInfo(String userID, String newToken, String client_type, String DeviceID, String WebID, String OpenID) throws InterruptedException {
        getLoginCacheService().setTokenInfo(userID,  newToken,  client_type,  DeviceID,  WebID,  OpenID);
        return userID;
    }
    @Override
    public String[] getTokenInfo(String token, String client_type) {

        return getLoginCacheService().getTokenInfo(token, client_type);
    }
}




