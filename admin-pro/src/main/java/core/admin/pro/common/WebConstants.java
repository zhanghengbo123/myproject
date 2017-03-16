package core.admin.pro.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * DATE:8/3/15 15:07
 * AUTHOR:liuxainglong
 */
public class WebConstants {
    public static final Pattern MOBILE_CHINESE_PATTERN = Pattern.compile(".*\\d{11}");

    public static final String USER_KEY = "DRAMA_USER_KEY";
    public static final int DRAMA_TYPE_ALL = 0;
    public static final int DRAMA_TYPE_HOT = 1;

    public static final String DRAMA_SMS_CODE_PREFIX = "SMS_CODE_PREFIX_";

    public static final Integer SYSTEM_MESSAGE_FOLLOW_TYPE = 1;
    public static final Integer SYSTEM_MESSAGE_COLLECT_TYPE = 2;

    public static final String NGINX_WWW_ROOT;
    public static final String WEB_PUBLISH_URL;

    /**当前城市是否有34网点*/
    public static final Integer IS_NETWORK_YES=1; //有
    public static final Integer IS_NETWORK_NO=0; //没有

    /**货物配送单状态*/
    public static final Integer DELIVERY_STATUS_SENDING=0; //发送中
    public static final Integer DELIVERY_STATUS_SUCCESS=1; //完成

    static {
        InputStream is = WebConstants.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
            NGINX_WWW_ROOT = (String)prop.get("nginx.static.root");
            WEB_PUBLISH_URL = (String)prop.get("web.ip");
        } catch (IOException e) {
            throw new IllegalArgumentException("config.properties load error!",e);
        }
    }
}
