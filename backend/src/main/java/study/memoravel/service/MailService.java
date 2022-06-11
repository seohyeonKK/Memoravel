package study.memoravel.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import study.memoravel.exception.MailServiceException;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@PropertySource("classpath:private.properties")
public class MailService {
    private final JavaMailSender emailSender;

    @Value("${mail.id}")
    private String senderEmail;

    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    private static String getAuthNumber() {
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rnd.nextInt(3); // 0~2 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char) (rnd.nextInt(26) + 97));
                    //  a~z  (ex. 1+97=98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char) (rnd.nextInt(26) + 65));
                    //  A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }

        return key.toString();
    }

    private MimeMessage createMessage(String receiverEmail, String authNumber) throws Exception {
        String text = "";
        text += "<div style='margin:100px;'>";
        text += "<h1> 안녕하세요 Memoravel 입니다. </h1>";
        text += "<br>";
        text += "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요<p>";
        text += "<br>";
        text += "<p>감사합니다!<p>";
        text += "<br>";
        text += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        text += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        text += "<div style='font-size:130%'>";
        text += "CODE : <strong>";
        text += authNumber + "</strong><div><br/> ";
        text += "</div>";

        MimeMessage message = emailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, receiverEmail);//보내는 대상
        message.setSubject("Memoravel 이메일 인증");//제목
        message.setText(text, "utf-8", "html");//내용
        message.setFrom(new InternetAddress(senderEmail, "Memoravel"));//보내는 사람
        return message;
    }

    public String sendCheckMail(String receiverEmail) {
        String authNumber = getAuthNumber();
        try {
            MimeMessage message = createMessage(receiverEmail, authNumber);
            emailSender.send(message);
        } catch (Exception e) {
            throw new MailServiceException();
        }
        return authNumber;
    }
}
