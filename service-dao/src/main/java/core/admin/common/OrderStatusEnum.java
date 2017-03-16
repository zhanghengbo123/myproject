package core.admin.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * liuxianglong
 */
public enum OrderStatusEnum {

    CANCELED(1,"已取消"),
    UNSHIPPED(2, "未发货"),
    SHIPPED(3, "已发货"),
    RESHIPED(4, "已退货"),
    COMPLETED(5,"已完成"),
    ARRIVALED(6,"已到货");

    //数字与字符串映射字典表
    public static Map<Integer, OrderStatusEnum> GLOBAL_MSG_STATUS_MAPPING_DICT = new LinkedHashMap<Integer, OrderStatusEnum>();

    static {
        GLOBAL_MSG_STATUS_MAPPING_DICT.put(UNSHIPPED.getCode(), UNSHIPPED);
        GLOBAL_MSG_STATUS_MAPPING_DICT.put(SHIPPED.getCode(), SHIPPED);
        GLOBAL_MSG_STATUS_MAPPING_DICT.put(RESHIPED.getCode(),RESHIPED);
        GLOBAL_MSG_STATUS_MAPPING_DICT.put(COMPLETED.getCode(),COMPLETED);
        GLOBAL_MSG_STATUS_MAPPING_DICT.put(CANCELED.getCode(),CANCELED);
        GLOBAL_MSG_STATUS_MAPPING_DICT.put(ARRIVALED.getCode(),CANCELED);
    }

    public static String getString(Integer code) {
        return GLOBAL_MSG_STATUS_MAPPING_DICT.get(code).getValue();
    }

    public static boolean checkKeyIsExist(Integer code) {
        if (GLOBAL_MSG_STATUS_MAPPING_DICT.containsKey(code)) {
            return true;
        }
        return false;
    }

    private Integer code;

    private String value;

    private OrderStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
