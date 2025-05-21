package com.clone.inflearn.util.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomPrincipal implements Principal {
    private Long userId;

    @Override
    public String getName() {
        return userId.toString();
    }

    public static Long getId() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(CustomPrincipal.class::isInstance)
                .map(CustomPrincipal.class::cast)
                .map(CustomPrincipal::getUserId)
                .orElse(null);
    }

}
