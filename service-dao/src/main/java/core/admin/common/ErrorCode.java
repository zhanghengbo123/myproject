package core.admin.common;

public class ErrorCode {
    // COMMON ERROR
    public static final int SUCCESSFUL = 0;
    public static final int UNKNOWN = 1;
    public static final int SERVICE_ERROR = 2;
    public static final int DAO_ERROR = 3;

    // BIZ ERROR
    public static final int ERR_USER_MOBILE_ERROR = 100;
    public static final int ERR_USER_DISABLE = 101;
    public static final int ERR_USER_NOT_SIGN_ERROR = 102;
    public static final int ERR_USER_LOGIN_ALREADY_ERROR = 103;
    public static final int ERR_USER_SMS_CODE_ERROR = 104;
    public static final int ERR_USER_TOKEN_GENERATE_ERROR = 105;
    public static final int ERR_USER_TOKEN_ERROR = 106;

    // park op error
    public static final int ERR_PARK_OP_REQUIRED_ERROR = 201;
    public static final int ERR_DRAMA_SIGNATURE_NULL_ERROR = 202;
    public static final int ERR_DRAMA_SIGNATURE_EXPIRE_ERROR = 203;
    public static final int ERR_DRAMA_SIGNATURE_NOT_MATCH_ERROR = 204;

    // collect follow error
    public static final int ERR_USER_COLLECT_ALREADY_ERROR = 301;
    public static final int ERR_USER_FOLLOW_ALREADY_ERROR = 302;
}
