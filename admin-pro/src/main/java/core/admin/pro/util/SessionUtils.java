package core.admin.pro.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    public static void cleanSession(HttpServletRequest request,String key) {
        HttpSession httpSession = getSession(request);
        httpSession.removeAttribute(key);
    }
}
