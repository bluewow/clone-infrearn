package com.clone.inflearn.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.util.UUID;

@Component
public class LogTraceIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper wrapped = new ContentCachingRequestWrapper(request);
        RequestContextHolder.getRequestAttributes().setAttribute("wrappedRequest", wrapped, RequestAttributes.SCOPE_REQUEST);

        try {
            String traceId = UUID.randomUUID().toString();
            MDC.put("traceId", traceId);
            response.setHeader("X-Trace-Id", traceId); // 응답 헤더에 추가

            filterChain.doFilter(wrapped, response);
        } finally {
            MDC.clear();
        }
    }
}
