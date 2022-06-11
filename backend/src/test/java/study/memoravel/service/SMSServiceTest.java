package study.memoravel.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@PropertySource("classpath:private.properties")
class SMSServiceTest {
    private final SMSService smsService;
    @Value("${coolSMS.sender}")
    private String sender;

    @Autowired
    public SMSServiceTest(SMSService smsService) {
        this.smsService = smsService;
    }

//    @Test
//    void 잘못된_전화번호_오류_확인() {
//        String phone = "1111111111111111111111111111111";
//
//        SMSServiceException exception = assertThrows(SMSServiceException.class, () -> smsService.sendMessage(phone));
//    }

    @Test
    void 문자_인증번호_확인() {
        String authNumber = smsService.sendMessage(sender);

        assertThat(authNumber.length()).isEqualTo(4);
    }
}