package study.memoravel.exception.jwt;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class JwtUnmatchedException extends BusinessException {
    public JwtUnmatchedException() {
        super(ErrorCode.JWT_UNMATCHED_EXCEPTION);
    }
}
