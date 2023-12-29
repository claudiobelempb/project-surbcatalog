package br.com.surb.surbcatalog.shared.AppProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "spring.email")
public class AppEmailConfigProperties {

    public static final String PROPERTY_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    public static final String PROPERTY_SMTP_PORT = "mail.smtp.port";
    public static final String PROPERTY_SMTP_AUTH = "mail.smtp.auth";
    public static final String PROPERTY_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";

    private final String host;
    private final String username;
    private final String password;
    private final String from;
    private final Map<String, String> properties;



    public AppEmailConfigProperties(String host, String username, String password, String from, Map<String, String> properties) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.from = from;
        this.properties = properties;
    }


    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFrom() {
        return from;
    }

    public String getProperty(String name) {
        return properties.get(name);
    }
}
