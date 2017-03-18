package core.admin.common;

import java.io.Serializable;
public class Result implements Serializable {
    private static final long serialVersionUID = 2351879786988258666L;

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
