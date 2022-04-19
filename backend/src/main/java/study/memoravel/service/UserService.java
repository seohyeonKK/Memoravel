package study.memoravel.service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.domain.User;
import study.memoravel.repository.UserRepository;
import study.memoravel.util.JWT;

import java.util.HashMap;

@Transactional
public class UserService {
    private static UserRepository userRepo;
    // coolSMS
    @Value("${coolSMSAPIKey}")
    private String coolSMSAPIKey;
    @Value("${coolSMSAPISecret}")
    private String coolSMSAPISecret;

    @Autowired
    public UserService(UserRepository userRepo) {
        UserService.userRepo = userRepo;
    }

    public String login(String userId, String userPassword) throws Exception {
        User result = userRepo.findByUserId(userId);
        if (result == null) {
            throw new Exception("존재하지 않는 ID");
        }
        if (result.getUserPassword().equals(userPassword)) {

            return JWT.createJWT(result);
        }
        return null;
    }

    public String join(User user) {
        userRepo.save(user);
        return JWT.createJWT(user);
    }

    public String checkPhone(String phoneNumber) {
        User result = userRepo.findByPhoneNumber(phoneNumber);
        if (result == null) {
            try {
                int randomNumber = (int) ((Math.random() * (9999 - 1000 + 1)) + 1000);
                sendMessage(phoneNumber, randomNumber);
                return Integer.toString(randomNumber);
            } catch (CoolsmsException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println(e.getCode());
                return null;
            }
        }
        // 이미 가입된 번호가 있으면 인증번호 X
        return null;
    }

    public Boolean checkMail(String mail) {
        User result = userRepo.findByEmail(mail);
        // TODO 이메일 인증 기능 만들기 md5, 8글자 정도의 문자열
        return result == null;
    }

    private void sendMessage(String phoneNumber, int randomNumber) throws CoolsmsException {
        Message coolSMS = new Message(coolSMSAPIKey, coolSMSAPISecret);

        // 4 params(to, from, type, text) is necessary
        HashMap<String, String> params = new HashMap<>();
        params.put("to", phoneNumber);
        params.put("from", "01025302359");
        params.put("type", "SMS");
        params.put("text", "[Memoravel] 가입 인증번호는 [" + randomNumber + "] 입니다.");

        coolSMS.send(params);
    }
}
