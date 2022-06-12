package study.memoravel.exception.jwt;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class JwtException extends BusinessException {
    public JwtException() {
        super(ErrorCode.JWT_ERROR);
    }

    public JwtException(ErrorCode errorCode) {
        super(errorCode);
    }
}
