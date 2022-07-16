package study.memoravel.aop;


import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import study.memoravel.dto.MemberInfo;
import study.memoravel.exception.jwt.JwtUnmatchedException;
import study.memoravel.exception.jwt.NoJwtException;
import study.memoravel.exception.member.MemberNotFoundException;
import study.memoravel.repository.MemberRepository;
import study.memoravel.util.JWT;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class AuthAspect {

    private final HttpServletRequest httpServletRequest;
    private final MemberRepository memberRepository;

    @Around("@annotation(study.memoravel.annotation.Auth)")
    public Object checkJWT(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String jwt = httpServletRequest.getHeader("authorization");
        if (jwt == null) {
            throw new NoJwtException();
        }
        long id = JWT.getIdFromJWT(jwt);
        MemberInfo memberInfo = memberRepository.findById(id);
        if (memberInfo == null) {
            throw new MemberNotFoundException();
        }
        if (!jwt.equals(memberInfo.getJwt())) {
            throw new JwtUnmatchedException();
        }

        MemberContext.MEMBER_CONTEXT.set(id);

        return proceedingJoinPoint.proceed();
    }
}
