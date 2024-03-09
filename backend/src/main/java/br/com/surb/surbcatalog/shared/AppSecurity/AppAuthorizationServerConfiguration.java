package br.com.surb.surbcatalog.shared.AppSecurity;

import br.com.surb.surbcatalog.modules.user.services.UserService;
import br.com.surb.surbcatalog.shared.AppSecurity.customgrant.AppCustomPasswordAuthenticationConverter;
import br.com.surb.surbcatalog.shared.AppSecurity.customgrant.AppCustomPasswordAuthenticationProvider;
import br.com.surb.surbcatalog.shared.AppSecurity.customgrant.AppCustomUserAuthorities;
import br.com.surb.surbcatalog.shared.AppSecurity.jwt.AppJwt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.authorization.InMemoryOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.InMemoryOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.oauth2.server.authorization.token.*;
import org.springframework.security.web.SecurityFilterChain;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Configuration
public class AppAuthorizationServerConfiguration {
    @Value("${spring.security.client-id}")
    private String clientId;

    @Value("${spring.security.client-secret}")
    private String clientSecret;

    @Value("${spring.security.jwt.duration}")
    private Integer jwtDurationSeconds;

    private final PasswordEncoder passwordEncoder;

    private final UserService userDetailsService;

    private final AppJwt appJwt;

    public AppAuthorizationServerConfiguration(PasswordEncoder passwordEncoder, UserService userDetailsService, AppJwt appJwt) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.appJwt = appJwt;
    }

    @Bean
    @Order(2)
    public SecurityFilterChain asSecurityFilterChain(HttpSecurity http) throws Exception {

        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

        // @formatter:off
        http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
                .tokenEndpoint(tokenEndpoint -> tokenEndpoint
                        .accessTokenRequestConverter(new AppCustomPasswordAuthenticationConverter())
                        .authenticationProvider(new AppCustomPasswordAuthenticationProvider(
                                authorizationService(),
                                tokenGenerator(),
                                userDetailsService,
                                passwordEncoder)));

        http.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()));
        // @formatter:on

        return http.build();
    }

    @Bean
    public OAuth2AuthorizationService authorizationService() {
        return new InMemoryOAuth2AuthorizationService();
    }

    @Bean
    public OAuth2AuthorizationConsentService oAuth2AuthorizationConsentService() {
        return new InMemoryOAuth2AuthorizationConsentService();
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        // @formatter:off
        RegisteredClient registeredClient = RegisteredClient
                .withId(UUID.randomUUID().toString())
                .clientId(clientId)
                .clientSecret(passwordEncoder.encode(clientSecret))
                .scope("read")
                .scope("write")
                .authorizationGrantType(new AuthorizationGrantType("password"))
                .authorizationGrantType(new AuthorizationGrantType("refresh_token"))
                .tokenSettings(tokenSettings())
                .clientSettings(clientSettings())
                .build();
        // @formatter:on

        return new InMemoryRegisteredClientRepository(registeredClient);
    }

    @Bean
    public TokenSettings tokenSettings() {
        // @formatter:off
        return TokenSettings.builder()
                .accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED)
                .accessTokenTimeToLive(Duration.ofSeconds(jwtDurationSeconds))
                .refreshTokenTimeToLive(Duration.ofSeconds(jwtDurationSeconds))
                .build();
        // @formatter:on
    }

    @Bean
    public ClientSettings clientSettings() {
        return ClientSettings.builder().build();
    }

    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder().build();
    }

    @Bean
    public OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator() {
        NimbusJwtEncoder jwtEncoder = new NimbusJwtEncoder(appJwt.jwkSource());
        JwtGenerator jwtGenerator = new JwtGenerator(jwtEncoder);
        jwtGenerator.setJwtCustomizer(tokenCustomizer());
        OAuth2AccessTokenGenerator accessTokenGenerator = new OAuth2AccessTokenGenerator();
        return new DelegatingOAuth2TokenGenerator(jwtGenerator, accessTokenGenerator);
    }

    @Bean
    public OAuth2TokenCustomizer<JwtEncodingContext> tokenCustomizer() {
        return context -> {
            OAuth2ClientAuthenticationToken principal = context.getPrincipal();
            AppCustomUserAuthorities user = (AppCustomUserAuthorities) principal.getDetails();
            List<String> authorities = user.getAuthorities().stream().map(x -> x.getAuthority()).toList();
            if (context.getTokenType().getValue().equals("access_token")) {
                // @formatter:off
                context.getClaims()
                        .claim("userId", user.getUserId())
                        .claim("firstName", user.getFirstName())
                        .claim("username", user.getUsername())
                        .claim("authorities", authorities);
                // @formatter:on
            }
        };
    }
}
