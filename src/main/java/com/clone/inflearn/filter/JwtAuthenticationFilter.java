package com.clone.inflearn.filter;

import com.clone.inflearn.util.exception.CustomException;
import com.clone.inflearn.util.exception.ErrorCode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = parseBearer(request);

        jwtTokenProvider.validateCheck(token);
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private String parseBearer(HttpServletRequest request) {
        if (request.getHeader(HttpHeaders.AUTHORIZATION) == null)
            throw new CustomException(ErrorCode.INVALID_ACCESS);

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        return token.replace("Bearer ", "");
    }
}
