package core.admin.common;

import core.admin.domain.NetworkUser;

import java.util.*;
import java.util.regex.Pattern;

public class AdminConstants {
    public static final String SESSION_USER_KEY = "username";
    public static final String SESSION_USER_MENU_KEY = "menulist";

    public static final String SMS_CODE_PREFIX = "SMS_CODE_PREFIX_";
    public static final Pattern MOBILE_CHINESE_PATTERN = Pattern.compile(".*\\d{11}");

    public static final String NGINX_WWW_ROOT="";
    public static final String HOST_IP="";
    /**用户状态*/
    public static final Integer USER_STATUS_NORMAL=1; //正常
    public static final Integer USER_STATUS_EXPIRE=2; //屏蔽

    /**当前城市是否有34网点*/
    public static final Integer IS_NETWORK_YES=1; //有
    public static final Integer IS_NETWORK_NO=0; //没有

    /**线路类型 1.直达，2:经过*/
    public static final Integer LINE_TYPE_NONSTOP=1;
    public static final Integer LINE_TYPE_PASS=2;

    /**货物配送单状态*/
    public static final Integer DELIVERY_STATUS_SENDING=0; //发送中
    public static final Integer DELIVERY_STATUS_SUCCESS=1; //完成

    public  static final Map<Integer,String> orderTypeMap = new HashMap<>();

    public  static final Map<Integer,String> orderCategory = new HashMap<>();

    public  static final Map<Integer,String> packageType = new HashMap<>();

    public  static final Map<Integer,String> payType = new HashMap<>();

    public  static final Map<Integer,String> priceType = new HashMap<>();

    /**
     * 车辆类型
     */
    public  static final Map<Integer,String> carType = new HashMap<>();

    public  static final Map<Integer,String> receiveType = new HashMap<>();

    public static final List<String> proList = new ArrayList<>();

    public  static NetworkUser user;

    // 订单类型（普通、危险、易碎）

    static {

        priceType.put(0,"元/吨");
        priceType.put(1,"元/方");

        carType.put(0,"平板车");
        carType.put(1,"高栏车");
        carType.put(2,"集装箱");
        carType.put(3,"半挂车");
        carType.put(4,"厢式车");
        carType.put(5,"冷藏车");

        payType.put(0,"先付");
        payType.put(1,"到付");
        payType.put(2,"回付");
        payType.put(3,"月结");

        receiveType.put(0,"自提");
        receiveType.put(1,"送货");

        orderTypeMap.put(1,"普通");
        orderTypeMap.put(2,"危险");
        orderTypeMap.put(3,"易碎");

        orderCategory.put(1,"分类一");
        orderCategory.put(2,"分类二");
        orderCategory.put(3,"分类三");

        packageType.put(6,"散装");
        packageType.put(1,"木箱");
        packageType.put(2,"纸箱");
        packageType.put(3,"麻袋");
        packageType.put(4,"塑料袋");
        packageType.put(5,"塑料桶");

        proList.add("北京市");
        proList.add("上海市");
        proList.add("天津市");
        proList.add("重庆市");
    }




    // 配送状态（未发货、部分发货、已发货、部分退货、已退货）
    public enum ShippingStatus {
        unshipped, partShipped, shipped, partReshiped, reshiped
    };

    //iframe,必须最后关闭窗口，否则执行不了刷新动作。
    public static final String WEB_IFRAME_SCRIPT = "<script type='text/javascript'>" +
            "parent.layer.msg('%s', {icon: 1,time: 1000}, function(){" +
            "   parent.location.reload();" +
            //"   parent.layer.close(parent.layer.getFrameIndex(window.name));" +
            "});" +
            "</script>";

    public static final String WEB_IFRAME_ERROR_SCRIPT = "<script type='text/javascript'>" +
            "layer.msg('%s', {icon: 3,time: 2000}, function(){" +
            "});" +
            "</script>";
}
