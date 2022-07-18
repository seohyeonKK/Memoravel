package study.memoravel.exception;


import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    // 시작
    PROPERTIES_READ_EXCEPTION(500, "B001", ".properties 파일을 읽는데 실패하였습니다."),

    // 공통
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),


    // JWT
    NO_JWT_EXCEPTION(401, "J001", "JWT가 없습니다."),
    JWT_UNMATCHED_EXCEPTION(401, "J002", "JWT가 저장된 값과 일치하지 않습니다.(다른 기기에서 접근)"),
    JWT_EXPIRED_EXCEPTION(401, "J003", "JWT가 만료되었습니다."),

    // 계정
    EMAIL_DUPLICATE_EXCEPTION(400, "A001", "이메일이 중복되었습니다."),
    NICKNAME_DUPLICATE_EXCEPTION(400, "A002", "닉네임이 중복되었습니다."),
    SIGN_IN_INFO_MISMATCH_EXCEPTION(400, "A003", "로그인 정보가 일치하지 않습니다."),

    // 회원 정보
    PHONE_NUMBER_DUPLICATE_EXCEPTION(400, "M001", "핸드폰번호가 중복되었습니다."),
    MEMBER_NOT_FOUND_EXCEPTION(400, "M003", "회원을 찾을 수 없습니다."),

    // 전송
    EMAIL_SEND_EXCEPTION(500, "S001", "메일 전송 오류"),
    SMS_SEND_EXCEPTION(500, "S002", "문자 전송 오류"),

    // Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    EMAIL_NOT_FOUND(400, "M000", "Email is not Exist"),
    USER_NOT_AUTHENTICATION(401, "M005", "User is not Authentication"),
    PASSWORD_MISMATCH_ERROR(400, "M008", "Password MisMatch Error"),
    DEVICE_TOKEN_NOT_FOUND_ERROR(400, "M008", "DeviceToken is not Exist"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),
    JSON_WRITE_ERROR(401, "C007", "JSON content that are not pure I/O problems"),
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
