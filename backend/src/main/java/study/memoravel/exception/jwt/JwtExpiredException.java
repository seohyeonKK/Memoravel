package study.memoravel.exception.jwt;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class JwtExpiredException extends BusinessException {
    public JwtExpiredException() {
        super(ErrorCode.JWT_EXPIRED_ERROR);
    }
}
