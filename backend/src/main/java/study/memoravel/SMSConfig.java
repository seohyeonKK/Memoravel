package study.memoravel;

import net.nurigo.java_sdk.api.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:private.properties")
public class SMSConfig {
    // coolSMS
    @Value("${coolSMS.api.key}")
    private String coolSMSAPIKey;
    @Value("${coolSMS.api.secret}")
    private String coolSMSAPISecret;

    @Bean
    public Message CoolSMS() {
        return new Message(coolSMSAPIKey, coolSMSAPISecret);
    }
}
