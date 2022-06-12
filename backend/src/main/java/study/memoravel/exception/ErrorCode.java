package study.memoravel.exception;


import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {


    // Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),
    JSON_WRITE_ERROR(401, "C007", "JSON content that are not pure I/O problems"),

    // JWT
    JWT_ERROR(401, "J001", "JWT가 없습니다."),
    JWT_UNMATCHED_ERROR(401, "J002", "JWT가 저장된 값과 일치하지 않습니다.(다른 기기에서 접근)"),
    JWT_EXPIRED_ERROR(401, "J003", "JWT가 만료되었습니다."),

    // User
    EMAIL_NOT_FOUND(400, "M000", "Email is not Exist"),
    EMAIL_DUPLICATION(400, "M001", "이메일이 중복되었습니다."),
    USER_NOT_FOUND(400, "M003", "User is not Exist"),
    NICKNAME_EMAIL_DUPLICATION(400, "M004", "NickName is Duplication"),
    USER_NOT_AUTHENTICATION(401, "M005", "User is not Authentication"),
    PASSWORD_MISMATCH_ERROR(400, "M008", "Password MisMatch Error"),
    DEVICE_TOKEN_NOT_FOUND_ERROR(400, "M008", "DeviceToken is not Exist"),

    // Alarm
    ALARM_NOT_FOUND_ERROR(400, "N001", "Alarm is not Exist"),

    // Email
    EMAIL_SEND_ERROR(500, "P001", "Email Send Error"),

    // AWS
    AWS_S3_ERROR(500, "A001", "AWS S3 Error");


    private final String code;
    private final String message;
    private final int httpStatus;

    ErrorCode(final int httpStatus, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
