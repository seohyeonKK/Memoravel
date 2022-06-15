package study.memoravel.exception.jwt;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class NoJwtException extends BusinessException {
    public NoJwtException() {
        super(ErrorCode.NO_JWT_EXCEPTION);
    }

    public NoJwtException(ErrorCode errorCode) {
        super(errorCode);
    }
}
