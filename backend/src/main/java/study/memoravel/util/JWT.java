package study.memoravel.util;

import io.jsonwebtoken.*;
import study.memoravel.domain.User;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class JWT {
    private static String secret;

    private static String getSecret() {
        Properties pt = new Properties();
        String result = null;
        try {
            pt.load(JWT.class.getResourceAsStream("/private.properties"));
            result = pt.getProperty("jwt.secret");
        } catch (IOException e) {
            System.out.println("properties 파일 읽기 오류");
        }
        return result;
    }

    public static String create(User.DTO userInfo) {
        if (secret == null) {
            secret = getSecret();
        }
        Date now = new Date();
        long expiredTime = 1000 * 60L * 30L; // 30분

        return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE) // header 설정
                .setIssuer(userInfo.getNickname()) // 발급자 설정
                .setIssuedAt(now) // 발급 시간 설정
                .setExpiration(new Date(now.getTime() + expiredTime)) // 만료 시간 설정
                .claim("email", userInfo.getEmail()) // 비공개 클레임 설정(ID만 사용)
                .claim("nickname", userInfo.getNickname())
                .claim("phoneNumber", userInfo.getPhoneNumber())
                .signWith(SignatureAlgorithm.HS256, secret) // 해싱 알고리즘과 시크릿 키 설정
                .compact();
    }

    public static String getEmailFromJWT(String jwtString) {
        Claims claims = JWT.parse(jwtString);
        return (String) claims.get("email");
    }

    private static Claims parse(String jwtString) throws ExpiredJwtException {
        if (secret == null) {
            secret = getSecret();
        }
        Jwt jwt = Jwts.parser().setSigningKey(secret).parse(jwtString);

        Claims claims = (Claims) jwt.getBody();
        if (checkExpire(claims)) {
            throw new ExpiredJwtException(jwt.getHeader(), (Claims) jwt.getBody(), "expired");
        }
        return claims;
    }

    private static Boolean checkExpire(Claims claims) {
        return claims.getExpiration() == null;
    }
}
