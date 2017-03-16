package core.admin.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 发送手机短信工具类
 * User: liuxianglong
 * Date: 16-05-08
 * Time: 上午11:42
 */
public class SendSMSMessageUtil {

    private static final Logger logger = LoggerFactory.getLogger(SendSMSMessageUtil.class);

    /**
     * 最大连接数
     */
    protected final static int MAX_TOTAL_CONNECTIONS = 1000;
    /**
     * 获取连接的最大等待时间
     */
    protected final static int WAIT_TIMEOUT = 1000;
    /**
     * 每个主机的最大并行链接数，默认为2
     */
    protected final static int MAX_CONNECTIONS_PER_HOST = 10;
    /**
     * 读取超时时间
     */
    protected final static int READ_TIMEOUT = 1000;


    /**
     * 美联软通：单个手机，发送短信验证码
     *
     * @param mobile  手机号
     * @param content 内容
     * @return “success:14170723309186” 同批次的手机号发送短信时，消息id是一样的
     */

    public static String sendSmsByMeiLian(String mobile, String content) {
        logger.info("[SendSMSMessageUtil]sendSmsByMeiLian method start.mobile:{},msgId:{}", mobile);
        String result = null;
        HttpURLConnection connection = null;
        BufferedReader in = null;
        try {
            // 创建StringBuffer对象用来操作字符串
            StringBuffer sb = new StringBuffer(MeiLianConstants.URL);
            // APIKEY
            sb.append(MeiLianConstants.APPKEY);
            //用户名
            sb.append(MeiLianConstants.USERNAME);
            // 向StringBuffer追加密码
            sb.append(MeiLianConstants.PASSWORD);
            // 向StringBuffer追加手机号码
            sb.append(MeiLianConstants.MOBILE);
            sb.append(mobile);
            // 向StringBuffer追加消息内容转URL标准码
            sb.append(MeiLianConstants.CONTENT);
            sb.append(URLEncoder.encode(content, "GBK"));
            // 创建url对象
            URL url = new URL(sb.toString());
            // 打开url连接
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(WAIT_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
            // 设置url请求方式 ‘get’ 或者 ‘post’
            connection.setRequestMethod(MeiLianConstants.REQUEST_METHOD_POST);
            // 发送
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            // 返回发送结果
            result = in.readLine();
            logger.info("send sms mobile:{},result:{},requestUrl:{}", mobile, result, sb.toString());
        } catch (Exception e) {
            logger.error("send sms by meilian error,mobile:{},detail:{}", mobile, e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("meilian in.close():error sendSMSUtil,mobile:{},content:{}", mobile, content);
                }
            }
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception e) {
                    logger.error("meilian connection.disconnect():error SendSMSUtil,mobile:{},content:{}", mobile, content);
                }
            }
        }
        return result;
    }

    /**
     * 美联软通国际号码的下发
     *
     * @param mobile  手机号
     * @param content 内容
     * @return “success:14170723309186” 同批次的手机号发送短信时，消息id是一样的
     */

    public static String sendNationalSmsByMeiLian(String mobile, String content) {
        logger.info("[SendSMSMessageUtil]sendNationalSmsByMeiLian method start.mobile:{},msgId:{}", mobile);
        String result = null;
        HttpURLConnection connection = null;
        BufferedReader in = null;
        try {
            // 创建StringBuffer对象用来操作字符串
            StringBuffer sb = new StringBuffer(MeiLianConstants.NATIONAL_URL);
            // APIKEY
            sb.append(MeiLianConstants.NATIONAL_APPKEY);
            //用户名
            sb.append(MeiLianConstants.NATIONAL_USERNAME);
            // 向StringBuffer追加密码
            sb.append(MeiLianConstants.NATIONAL_PASSWORD);
            // 向StringBuffer追加手机号码
            sb.append(MeiLianConstants.MOBILE);
            sb.append(mobile);
            sb.append(MeiLianConstants.ENCODE);
            // 向StringBuffer追加消息内容转URL标准码
            sb.append(MeiLianConstants.CONTENT);
            sb.append(URLEncoder.encode(content, "GBK"));
            // 创建url对象
            URL url = new URL(sb.toString());
            // 打开url连接
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(WAIT_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
            // 设置url请求方式 ‘get’ 或者 ‘post’
            connection.setRequestMethod(MeiLianConstants.REQUEST_METHOD_POST);
            // 发送
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            // 返回发送结果
            result = in.readLine();
            logger.info("send national sms mobile:{},result:{},requestUrl:{}", mobile, result, sb.toString());
        } catch (Exception e) {
            logger.error("send national sms by meilian error,mobile:{},detail:{}", mobile, e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("meilian in.close():error sendSMSUtil,mobile:{},content:{}", mobile, content);
                }
            }
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception e) {
                    logger.error("meilian connection.disconnect():error SendSMSUtil,mobile:{},content:{}", mobile, content);
                }
            }
        }
        return result;
    }

}