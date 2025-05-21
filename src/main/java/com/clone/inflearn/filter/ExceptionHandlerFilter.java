package com.clone.inflearn.filter;

import com.clone.inflearn.util.exception.CustomException;
import com.clone.inflearn.util.exception.ExceptionLogUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            filterChain.doFilter(request, response);
        } catch (CustomException ce) {
            ExceptionLogUtil.logCustomException(ce, request);
        } catch (Exception e) {
            ExceptionLogUtil.logException(e, request);
        } finally {
            SecurityContextHolder.clearContext();
        }
    }
}
