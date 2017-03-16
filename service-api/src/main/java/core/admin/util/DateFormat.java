package core.admin.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateFormat {
    public static final String FORMAT_TIME = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * 将Long类型的专为String
     */
    public static String formatDate(Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

}
