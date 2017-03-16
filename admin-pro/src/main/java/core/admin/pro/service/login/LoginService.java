package core.admin.pro.service.login;

/**
 * Created by chenshaofeng1996 on 2016/9/2.
 */
public interface LoginService {

    public final static String CACHE_TYPE_LOCAL = "LOCAL";
    public final static String CACHE_TYPE_REDIS = "REDIS";
    public final static String CACHE_TYPE_MEM = "MEMCACHE";

    /**
     *添加用户的token
     * @param userID//用户id
     * @param newToken//token
     * @param client_type//连接类型
     */
    void setUserLoginInfo(String userID, String newToken, String client_type) throws InterruptedException;

    /**
     * 获取用户的token
     * @param userID
     * @param client_type
     * @return
     */
    String[] getUserLoginInfo(String userID, String client_type);

    /**
     * 刷新用户的token
     * @param userID
     * @param newToken
     * @param client_type
     */
    void refreshUserLoginInfo(String userID, String newToken, String client_type);

    /**
     *设置token信息
     * @param userID //用户id
     * @param newToken //token
     * @param client_type //连接类型
     * @param DeviceID //app设备ip
     * @param WebID //网站客户端ip
     * @param OpenID //微信用户opendID
     */
    String setTokenInfo(String userID, String newToken, String client_type, String DeviceID, String WebID, String OpenID) throws InterruptedException;

    /**
     *  获取token值
      * @param token
     * @param client_type
     * @returntoken 和 登录类型
     */
    String[] getTokenInfo(String token, String client_type);
}

