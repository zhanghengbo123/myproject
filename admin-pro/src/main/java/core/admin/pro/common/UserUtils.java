package core.admin.pro.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import core.admin.pro.common.exception.ServiceDataException;
import core.admin.pro.common.interceptor.LoginInterceptor;
import core.admin.pro.common.util.AES;
import core.admin.domain.NetworkUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class UserUtils {

    private static final Logger logger = LoggerFactory.getLogger(UserUtils.class);

    // sms code 5 minutes
    public static final Cache<String, String> CODES = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

    // signature 20 minutes
    public static final Cache<String, Long> SIGNATURES = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(20, TimeUnit.MINUTES)
            .build();

    public static NetworkUser getUser() {
        NetworkUser user = LoginInterceptor.get();

        if (user == null) {
            logger.error("user not login");
            throw new ServiceDataException(core.admin.common.ErrorCode.ERR_USER_NOT_SIGN_ERROR);
        }

        return user;
    }

    public static Long getUid() {
        return getUser().getId();
    }

    public static String getToken() {
        return AES.encrypt(String.valueOf(getUid()));
    }
}
