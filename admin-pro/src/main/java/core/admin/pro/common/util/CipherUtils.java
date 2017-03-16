package core.admin.pro.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by 祥龙 on 15/12/07.
 */
public class CipherUtils {
    private static final Logger logger = LoggerFactory.getLogger(CipherUtils.class);

    public static String md5(String raw){
        return DigestUtils.md5Hex(raw);
    }

    public static void main(String[] args) {
        System.out.println(CipherUtils.md5("123456"));
        System.out.println(CipherUtils.md5("654321"));
    }
}
