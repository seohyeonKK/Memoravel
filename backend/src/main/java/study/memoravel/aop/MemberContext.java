package study.memoravel.aop;

import study.memoravel.exception.jwt.NoJwtException;

public class MemberContext {
    public static final ThreadLocal<Long> MEMBER_CONTEXT = new ThreadLocal<>();

    public static long getCurrentMemberId() {
        if (MEMBER_CONTEXT.get() != null) {
            return MEMBER_CONTEXT.get();
        }
        throw new NoJwtException();
    }
}
