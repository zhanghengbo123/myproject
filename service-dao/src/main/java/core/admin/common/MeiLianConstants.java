package core.admin.common;

/**
 * 美联发短信参数
 */
public class MeiLianConstants {


    //美联
    public static final String SMS_OPERATOR_ML = "ML";
    /**
     * 美联发短信接口url
     */
    public static final String URL = "http://m.5c.com.cn/api/send/?";
    /**
     * 美联发短信appkey参数用户名
     */
    public static final String APPKEY = "apikey=bcec03bc544beffa7629df6a5e463203";
    /**
     * 美联发短信用户名参数名
     */
    public static final String USERNAME = "&username=18910721771";
    /**
     * 百悟发短信密码参数名
     */
    public static final String PASSWORD = "&password=asdf123";
    /**
     * 百悟发短信手机号
     */
    public static final String MOBILE = "&mobile=";
    /**
     * 百悟发短信内容¬
     */
    public static final String CONTENT = "&content=";

    public static final String REQUEST_METHOD_POST = "POST";

    public static final String REQUEST_METHOD_GET = "GET";

    //----------美联国际短信的下发-----------//
    /**
     * 美联发短信接口url
     */
    public static final String NATIONAL_URL = "http://m.5c.com.cn/api/send/index.php?";

    /**
     * 美联发短信appkey参数用户名
     */
    public static final String NATIONAL_APPKEY = "apikey=bcec03bc544beffa7629df6a5e463203";
    /**
     * 美联国际短信下发的用户名
     */
    public static final String NATIONAL_USERNAME = "&username=18910721771";
    /**
     * 美联国际短信下发的md5密码加密
     */
    public static final String NATIONAL_PASSWORD = "&password_md5=asdf123";
    /**
     * GBK 或 UTF-8,如您的编码(文件)是 GBK/GB2312/ASCII,请传入 GBK。如您的编码为 UTF-8,请传入 UTF-8。该参数不区分大小写。示 例:encode=GBK 或 encode=UTF-8
     */
    public static final String ENCODE = "&encode=gbk";
}
