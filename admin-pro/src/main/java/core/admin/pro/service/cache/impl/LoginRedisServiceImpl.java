package core.admin.pro.service.cache.impl;

import core.admin.pro.service.cache.LoginCacheService;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * Created by chenshaofeng1996 on 2016/9/2.
 */
public class LoginRedisServiceImpl implements LoginCacheService {

    @Resource
    private Jedis jedis;

    @Override

    public void setUserLoginInfo(String userID, String newToken, String client_type) {
        String key = LOGIN_USER_HASH+userID;
        jedis.hset(key,TOKEN_TYPE+client_type,newToken);
        jedis.hset(key,CLIENT_TYPE,client_type);
        jedis.expire(key,USERINFO_TIMEOUT);
    }
    @Override

    public String[] getUserLoginInfo(String userID,String client_type) {
        String key = LOGIN_USER_HASH+userID;
        String token= jedis.hget(key, TOKEN_TYPE+client_type);
        if(token==null){
            return  null;
        }else{
            String[] result =  new String[]{token,jedis.hget(key, CLIENT_TYPE)};
            return result;
        }
    }

    @Override

    public void refreshUserLoginInfo(String userID, String newToken, String client_type) {
        String key = LOGIN_USER_HASH+userID;
        String token = jedis.hget(key, TOKEN_TYPE + client_type);
        String[] result = getTokenInfo(token, client_type);
        if(result!=null){
            jedis.del(LOGIN_TOKEN_HASH+token);
        }
        jedis.hset(key,TOKEN_TYPE + client_type,newToken);
    }

    public void setTokenInfo(String userID, String newToken, String client_type, String DeviceID, String WebID, String OpenID) {
        String key=LOGIN_TOKEN_HASH+newToken;
        jedis.hset(key,USER_ID,userID);
        jedis.hset(key,CLIENT_TYPE,client_type);
        jedis.hset(key,"DeviceID",DeviceID);
        jedis.hset(key,"WebID",WebID);
        jedis.hset(key,"OpenID",OpenID);
        jedis.expire(key,TOKEN_TIMEOUT);
    }
    @Override

    public String[] getTokenInfo(String token, String client_type) {

        String key=LOGIN_TOKEN_HASH+token;
        String uid = jedis.hget(key, USER_ID);
        if(uid==null){
            return  null;
        }else{
            String[] result = new String[]{uid,jedis.hget(key,CLIENT_TYPE)};
            return result;
        }
    }
}
