package study.memoravel.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    public static String createJWT(User.DTO userInfo) {
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
                .signWith(SignatureAlgorithm.HS256, secret) // 해싱 알고리즘과 시크릿 키 설정
                .compact();
    }

    public static Claims parseJWT(String jwt) throws Exception {
        if (secret == null) {
            secret = getSecret();
        }
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
        if (checkExpire(claims)) {
            throw new Exception("JWT 만료");
        }
        return claims;
    }

    private static Boolean checkExpire(Claims claims) {
        return claims.getExpiration() == null;
    }
}
