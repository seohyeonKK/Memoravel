package study.memoravel.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoding {

    public static String getSalt() {
        return BCrypt.gensalt();
    }

    public static String getBCrypt(String password, String salt) {
        return BCrypt.hashpw(password, salt);
    }

    public static Boolean checkBCrypt(String value, String target) {
        return BCrypt.checkpw(value, target);
    }

    public static String getMD5(String email) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(email.getBytes());
        byte[] byteData = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte byteDatum : byteData) {
            sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
