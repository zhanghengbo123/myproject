
package core.admin.common.constants.exception;

/**
 *
 * Created by xianglong on 14-11-5.
 */
public class AppException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public AppException() {
		super();
	}
	
	public AppException(String message) {
		super(message);
	}

	public AppException(String message,int code) {
		super(message);
		this.code = code;
	}
	
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AppException(Throwable cause) {
		super(cause);
	}

	private int code = 0;

	public AppException(int code) {
		// message todo
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
