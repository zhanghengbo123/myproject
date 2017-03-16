package core.admin.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Author    : liuxianglong
 * CreateTime:  15/12/12  20:58
 * <p/>
 * Version: 1.0
 * <p/>
 */
public class UserUtils {


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

/*    public static final Cache<String, List<LogisticsInfo>> infos = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(30, TimeUnit.MINUTES)
            .build();*/
   static Map<Integer,String> userMap = new HashMap<>();
    private UserUtils() {}
    private static UserUtils single=null;
    //静态工厂方法
    public static UserUtils getInstance() {
        if (single == null) {
            single = new UserUtils();
        }
        return single;
    }
public void setUserMap(Map userP){
    userMap = userP;
}
    public String getUser(Integer id) {

         if(userMap!=null && userMap.size()>0){

             return userMap.get(id);
         }

        return null;
    }
}
