package br.com.surb.surbcatalog.shared.AppSecurity.customgrant;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AppCustomUserAuthorities {
    private final String username;
    private final Collection<? extends GrantedAuthority> authorities;

    public AppCustomUserAuthorities(String username, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
