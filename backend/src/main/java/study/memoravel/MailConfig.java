package study.memoravel;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:private.properties")
public class MailConfig {
    @Value("${mail.id}")
    private String id;
    @Value("${mail.password}")
    private String password;

    @Bean
    public JavaMailSender javaMailService() {
        int port = 456;
        String encoding = "UTF-8";

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername(id);
        javaMailSender.setPassword(password);
        javaMailSender.setPort(port);
        javaMailSender.setJavaMailProperties(getMailProperties());
        javaMailSender.setDefaultEncoding(encoding);
        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties pt = new Properties();
        int socketPort = 465;
        boolean auth = true;
        boolean starttls = true;
        boolean starttls_required = true;
        boolean fallback = false;

        pt.put("mail.smtp.socketFactory.port", socketPort);
        pt.put("mail.smtp.auth", auth);
        pt.put("mail.smtp.starttls.enable", starttls);
        pt.put("mail.smtp.starttls.required", starttls_required);
        pt.put("mail.smtp.socketFactory.fallback", fallback);
        pt.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        return pt;
    }
}
