package core.admin.pro.common.util;

/**
 *
 * Created by 祥龙 on 15/12/07.
 */
public class PhoneUtils {

    public static String normalizeChineseMobile(String mobile) {
        Integer length = mobile.length();
        return mobile.substring(length - 11);
    }
}
