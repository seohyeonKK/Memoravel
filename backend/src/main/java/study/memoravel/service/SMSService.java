package study.memoravel.service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@PropertySource("classpath:private.properties")
public class SMSService {
    private final Message smsService;

    @Value("${coolSMS.sender}")
    private String sender;

    @Autowired
    public SMSService(Message smsService) {
        this.smsService = smsService;
    }

    public String sendMessage(String phoneNumber) throws CoolsmsException {
        int randomNumber = (int) ((Math.random() * (9999 - 1000 + 1)) + 1000);

        // 4 params(to, from, type, text) is necessary
        HashMap<String, String> params = new HashMap<>();
        params.put("to", phoneNumber);
        params.put("from", sender);
        params.put("type", "SMS");
        params.put("text", "[Memoravel] 가입 인증번호는 [" + randomNumber + "] 입니다.");
        smsService.send(params);

        return String.valueOf(randomNumber);
    }
}
