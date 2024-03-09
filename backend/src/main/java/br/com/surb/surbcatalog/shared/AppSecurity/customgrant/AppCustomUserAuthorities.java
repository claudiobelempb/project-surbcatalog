package br.com.surb.surbcatalog.shared.AppSecurity.customgrant;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class AppCustomUserAuthorities {
    private final String userId;
    private final String username;
    private final String firstName;
    private final Collection<? extends GrantedAuthority> authorities;

    public AppCustomUserAuthorities(String userId, String username, String firstName, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.authorities = authorities;
    }

}
