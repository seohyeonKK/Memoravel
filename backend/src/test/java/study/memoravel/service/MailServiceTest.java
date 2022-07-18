package study.memoravel.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import study.memoravel.exception.mail.MailServiceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@PropertySource("classpath:private.properties")
@SpringBootTest
class MailServiceTest {
    private final MailService mailService;
    @Value("${mail.id}")
    private String mailId;

    @Autowired
    public MailServiceTest(MailService mailService) {
        this.mailService = mailService;
    }

    @Test
    void 이메일_인증번호_확인() {
        String authString1 = mailService.sendCheckMail(mailId);
        String authString2 = mailService.sendCheckMail(mailId);

        assertThat(authString1.length()).isEqualTo(8);
        assertThat(authString1).isNotEqualTo(authString2);
    }


    @Test
    void 잘못된_이메일_오류_확인() {
        String testMailId = "123123123123";

        MailServiceException exception = assertThrows(MailServiceException.class, () -> mailService.sendCheckMail(testMailId));

    }

}