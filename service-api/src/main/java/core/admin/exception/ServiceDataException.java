package core.admin.exception;

public class ServiceDataException extends RuntimeException {
    private static final long serialVersionUID = -5838160341873917520L;

    private int code = 0;
//    private String message;

    public ServiceDataException() {
        super();
    }

    public ServiceDataException(int code) {
        super();
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
