package core.admin.pro.common;

import com.google.common.base.Strings;
import core.admin.common.*;
import core.admin.common.constants.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 Created by xianglong on 16/4/28.
 */
@ControllerAdvice
public class BaseAction {

    private static Logger logger = LoggerFactory.getLogger(BaseAction.class);


    @ExceptionHandler(Exception.class)
    public core.admin.pro.common.Result runtimeExceptionHandler(Exception e, HttpServletRequest request) {


        core.admin.pro.common.Result resultJson = new core.admin.pro.common.Result();
        if (e instanceof AppException) {
            resultJson.setC(((AppException) e).getCode());
            return resultJson;
        }

        logger.error(e.getMessage(), e);

        resultJson.setC(core.admin.pro.common.Result.SYSTEM_UNKNOWN_EXCEPTION);
        resultJson.setM("服务器异常");
        return resultJson;
    }


    protected static String getIp(HttpServletRequest request) {
        String sff = request.getHeader("X-Forwarded-For");
        if (Strings.isNullOrEmpty(sff)) {
            sff = request.getHeader("X-Real-IP");
        }
        if (Strings.isNullOrEmpty(sff)) {
            return Strings.isNullOrEmpty(request.getRemoteAddr()) ? "" : request.getRemoteAddr();
        }
        String[] ips = sff.split(",");
        String realIp = ips[0];
        return realIp;
    }

}
