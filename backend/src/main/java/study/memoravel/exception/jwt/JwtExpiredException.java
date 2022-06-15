package study.memoravel.exception.jwt;

import lombok.Getter;
import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

@Getter
public class JwtExpiredException extends BusinessException {
    private final int memberId;
    private final String nickname;

    public JwtExpiredException(int memberId, String nickname) {
        super(ErrorCode.JWT_EXPIRED_EXCEPTION);
        this.memberId = memberId;
        this.nickname = nickname;
    }
}
