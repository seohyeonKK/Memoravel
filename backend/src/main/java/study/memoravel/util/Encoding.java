package study.memoravel.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encoding {

    public static String getBCrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static Boolean checkBCrypt(String value, String target) {
        return BCrypt.checkpw(value, target);
    }
}
