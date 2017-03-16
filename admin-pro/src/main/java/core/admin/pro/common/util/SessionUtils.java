package core.admin.pro.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * Created by 祥龙 on 15/12/07.
 * */
public class SessionUtils {
    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    public static <T> T getSessionValue(HttpServletRequest request,String key) {

        HttpSession httpsession = getSession(request);
        return (T)httpsession.getAttribute(key);
    }

    public static void setSession(HttpServletRequest request,String key,Object value) {
        HttpSession httpSession = getSession(request);
        httpSession.setAttribute(key,value);
    }
}
