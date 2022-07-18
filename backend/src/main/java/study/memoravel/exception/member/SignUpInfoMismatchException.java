package study.memoravel.exception.member;


import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class SignUpInfoMismatchException extends BusinessException {
    public SignUpInfoMismatchException() {
        super(ErrorCode.SIGN_IN_INFO_MISMATCH_EXCEPTION);
    }
}
