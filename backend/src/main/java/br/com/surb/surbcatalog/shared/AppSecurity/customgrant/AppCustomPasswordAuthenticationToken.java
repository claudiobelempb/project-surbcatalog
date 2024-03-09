package br.com.surb.surbcatalog.shared.AppSecurity.customgrant;

import lombok.Getter;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;

import java.io.Serial;
import java.util.*;

@Getter
public class AppCustomPasswordAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String userId;
    private final String firstName;
    private final String username;
    private final String password;
    private final Set<String> scopes;

    public AppCustomPasswordAuthenticationToken(
            Authentication clientPrincipal,
            @Nullable Set<String> scopes,
            @Nullable Map<String, Object> additionalParameters) {
        super(
                new AuthorizationGrantType("password"),
                clientPrincipal,
                additionalParameters
        );
        this.userId = (String) additionalParameters.get("userId");
        this.firstName = (String) additionalParameters.get("firstName");
        this.username = (String) additionalParameters.get("username");
        this.password = (String) additionalParameters.get("password");
        this.scopes = Collections.unmodifiableSet(
                scopes != null ? new HashSet<>(scopes) : Collections.emptySet());

    }

}
