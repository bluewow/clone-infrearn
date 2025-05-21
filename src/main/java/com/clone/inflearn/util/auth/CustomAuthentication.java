package com.clone.inflearn.util.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthentication extends UsernamePasswordAuthenticationToken {
    public Long userId;

    public CustomAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        CustomPrincipal customPrincipal = (CustomPrincipal) principal;
        this.userId = customPrincipal.getUserId();
    }
}
