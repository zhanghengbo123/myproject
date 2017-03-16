package core.admin.pro.common;

import core.admin.common.ErrorCode;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = -6021601541007680588L;

    public static final Integer SYSTEM_UNKNOWN_EXCEPTION = 20000;//操作异常

    private Integer c = ErrorCode.SUCCESSFUL;

    private String m = "";

    private Object d;

    public static final Result getNew(){
        return new Result();
    }

    public static final Result getFailed(){
        return new Result().setC(ResultCode.SERVICE_ERROR);
    }

    public Integer getC() {
        return c;
    }

    public Result setC(Integer c) {
        this.c = c;
        return this;
    }

    public String getM() {
        return m;
    }

    public Result setM(String m) {
        this.m = m;
        return this;
    }

    public Object getD() {
        return d;
    }

    public Result setD(Object d) {
        this.d = d;
        return this;
    }
}
