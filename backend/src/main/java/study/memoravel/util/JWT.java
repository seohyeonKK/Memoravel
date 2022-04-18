package study.memoravel.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import study.memoravel.domain.User;

import java.util.Date;

public class JWT {
    private static final String secretKey = "secret!!";

    public static String createJWT(User user) {
        // TODO: secret key 어떤걸 사용할지
        // TODO: 어떤 값을 payload(claim)으로 사용할지

        Date now = new Date();
        long expiredTime = 1000 * 60L * 30L; // 30분

        return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE) // header 설정
                .setIssuer(user.getUserName()) // 발급자 설정
                .setIssuedAt(now) // 발급 시간 설정
                .setExpiration(new Date(now.getTime() + expiredTime)) // 만료 시간 설정
                .claim("id", user.getId()) // 비공개 클레임 설정
                .claim("password", user.getUserPassword())
                .signWith(SignatureAlgorithm.HS256, secretKey) // 해싱 알고리즘과 시크릿 키 설정
                .compact();
    }

    public static Claims parseJWT(String jwt) throws Exception {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
        if (checkExpire(claims)) {
            throw new Exception("JWT 만료");
        }
        return claims;
    }

    private static Boolean checkExpire(Claims claims) {
        return claims.getExpiration() == null;
    }
}
