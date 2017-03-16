package core.admin.pro.service.cache.impl;

import core.admin.pro.json.SafeLoginControllerJson;
import core.admin.pro.service.cache.LoginCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.Cache.ValueWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenshaofeng1996 on 2016/9/2.
 */

public class LoginCacheServiceImpl implements LoginCacheService {
    private static Logger logger = LoggerFactory.getLogger(SafeLoginControllerJson.class);


    @Autowired
    private CacheManager cacheManager ;


    private  Cache getCache(){

        return cacheManager.getCache("loginCache");
    }

    private String getKey(String userid){
        return LOGIN_USER_HASH+userid;
    }

    /**
     *添加用户的token
     * @param userID//用户id
     * @param newToken//token
     * @param client_type//连接类型
     */
    @Override
    public void setUserLoginInfo(String userID, String newToken, String client_type) throws InterruptedException {
        String key = LOGIN_USER_HASH+userID;

        Map<String,String> map = new HashMap();
        map.put(TOKEN_TYPE+client_type,newToken);
        map.put(CLIENT_TYPE,client_type);
        getCache().put(key,map);

    }

    /**
     * 获取用户的token
     * @param userID
     * @param client_type
     * @return
     */
    @Override
    public String[] getUserLoginInfo(String userID,String client_type) {

        String key = LOGIN_USER_HASH+userID;
        String token=null;
        String clientype = null;
            ValueWrapper vm = getCache().get(key);
            if(vm!=null){
                Map map= (Map)(vm.get());
                token = map.get(TOKEN_TYPE+client_type).toString();
                clientype =map.get(CLIENT_TYPE).toString();
        }else{
            return  null;
        }
        String[] result =  new String[]{token ,clientype};
            return result;
    }

    /**
     * 刷新用户的token
     * @param userID
     * @param newToken
     * @param client_type
     */
    @Override
    public void refreshUserLoginInfo(String userID, String newToken, String client_type) {
        ValueWrapper vm = getCache().get(getKey(userID));
        String token = null;
        if(vm!=null){
               Map map= (Map)(vm.get());
           token  = map.get(TOKEN_TYPE+client_type).toString();
        }

        String[] result = getTokenInfo(token, client_type);
        if(result!=null){
            vm=null;
        }
        Map map = new HashMap();
        map.put(CLIENT_TYPE,client_type);
        map.put(TOKEN_TYPE+client_type,newToken);
        getCache().put(getKey(userID),map);

    }

    /**
     *设置token信息
     * @param userID //用户id
     * @param newToken//token
     * @param client_type//连接类型
     * @param DeviceID//app设备ip
     * @param WebID//网站客户端ip
     * @param OpenID//微信用户opendID
     */
    @Override
    public void setTokenInfo(String userID, String newToken, String client_type, String DeviceID, String WebID, String OpenID) throws InterruptedException {

        String key=LOGIN_TOKEN_HASH+newToken;
        Map map = new HashMap();
        map.put(USER_ID,userID);
        map.put(CLIENT_TYPE,client_type);
        map.put("DeviceID",DeviceID);
        map.put("WebID",WebID);
        map.put("OpenID",OpenID);
        getCache().put(key,map);

    }

    /**
     *  获取token值
     * @param token
     * @param client_type
     * @returntoken 和 登录类型
     */
    @Override
    public String[] getTokenInfo(String token, String client_type) {

        String key=LOGIN_TOKEN_HASH+token;

        ValueWrapper vm = getCache().get(key);
        String uid =null;
        String clientype =null;
        if(vm!=null){
              Map map=(Map)vm.get();
            uid =map.get(USER_ID).toString();
            clientype=map.get(CLIENT_TYPE).toString();

        }

        if(uid==null){
            return  null;
        }else{
            String[] result =  new String[]{uid,clientype};
            return result;
        }
    }
}
