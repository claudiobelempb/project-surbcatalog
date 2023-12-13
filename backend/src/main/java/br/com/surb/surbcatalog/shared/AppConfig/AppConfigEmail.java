package br.com.surb.surbcatalog.shared.AppConfig;

import br.com.surb.surbcatalog.shared.AppProperties.AppEmailConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

import static br.com.surb.surbcatalog.shared.AppProperties.AppEmailConfigProperties.*;

@Configuration
public class AppConfigEmail {
    private final AppEmailConfigProperties appEmailConfigProperties;

    public AppConfigEmail(AppEmailConfigProperties appEmailConfigProperties) {
        this.appEmailConfigProperties = appEmailConfigProperties;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailsend = new JavaMailSenderImpl();
        mailsend.setHost(appEmailConfigProperties.getHost());
        mailsend.setPort(Integer.parseInt(appEmailConfigProperties.getProperty(PROPERTY_SMTP_PORT)));
        mailsend.setUsername(appEmailConfigProperties.getUsername());
        mailsend.setPassword(appEmailConfigProperties.getPassword());

        Properties properties = mailsend.getJavaMailProperties();
        properties.put(PROPERTY_TRANSPORT_PROTOCOL, appEmailConfigProperties.getProperty(PROPERTY_TRANSPORT_PROTOCOL));
        properties.put(PROPERTY_STMP_AUTH, appEmailConfigProperties.getProperty(PROPERTY_STMP_AUTH));
        properties.put(PROPERTY_SMTP_STARTTLS_ENABLE, appEmailConfigProperties.getProperty(PROPERTY_SMTP_STARTTLS_ENABLE));

        return mailsend;
    }
}
