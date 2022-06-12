package study.memoravel.aop;

import study.memoravel.exception.jwt.JwtException;

public class MemberContext {
    public static final ThreadLocal<Integer> MEMBER_CONTEXT = new ThreadLocal<>();

    public static int getCurrentMemberId() {
        if (MEMBER_CONTEXT.get() != null) {
            return MEMBER_CONTEXT.get();
        }

        throw new JwtException();
    }
}
