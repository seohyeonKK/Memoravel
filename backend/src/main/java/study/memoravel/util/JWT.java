package study.memoravel.util;

import io.jsonwebtoken.*;
import study.memoravel.exception.boot.PropertiesReadException;
import study.memoravel.exception.jwt.JwtExpiredException;

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
            throw new PropertiesReadException();
        }
        return result;
    }

    public static String create(long id, String nickname) {
        if (secret == null) {
            secret = getSecret();
        }
        Date now = new Date();
        long expiredTime = 1000 * 60L * 30L; // 30분

        return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE) // header 설정
                .setIssuer(nickname) // 발급자 설정
                .setIssuedAt(now) // 발급 시간 설정
                .setExpiration(new Date(now.getTime() + expiredTime)) // 만료 시간 설정
                .claim("id", id) // 비공개 클레임 설정(ID만 사용)
                .claim("date", now)
                .signWith(SignatureAlgorithm.HS256, secret) // 해싱 알고리즘과 시크릿 키 설정
                .compact();
    }

    public static long getIdFromJWT(String jwtString) {
        Claims claims = JWT.parse(jwtString);

        return Long.valueOf((Integer) claims.get("id"));
    }

    private static Claims parse(String jwtString) {
        if (secret == null) {
            secret = getSecret();
        }
        jwtString = jwtString.replaceFirst("Bearer ", "");
        Jwt jwt = Jwts.parser().setSigningKey(secret).parse(jwtString);

        Claims claims = (Claims) jwt.getBody();
        if (checkExpire(claims)) {
//            throw new ExpiredJwtException(jwt.getHeader(), (Claims) jwt.getBody(), "expired");
            throw new JwtExpiredException((Integer) claims.get("id"), claims.getIssuer());
        }
        return claims;
    }

    private static Boolean checkExpire(Claims claims) {
        return claims.getExpiration() == null;
    }
}
