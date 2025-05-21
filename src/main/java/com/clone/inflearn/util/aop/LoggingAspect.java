package com.clone.inflearn.util.aop;

import com.clone.inflearn.util.auth.CustomPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.UnsupportedEncodingException;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.clone.inflearn..*.api..*(..))")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) attrs.getAttribute("wrappedRequest", RequestAttributes.SCOPE_REQUEST);

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long elapsedTime = System.currentTimeMillis() - start;

        String httpMethod = request.getMethod();
        String requestURI = request.getRequestURI();
        if (elapsedTime > 5000) {
            log.warn("[{} URI={}, Execution Time: {}ms]",
                    httpMethod,
                    requestURI,
                    elapsedTime);
        }

        if (httpMethod.equals("GET")) {
            log.info("[{} URI={}, userId={}, PARAMETER={}]",
                    httpMethod,
                    requestURI,
                    CustomPrincipal.getId(),
                    request.getQueryString());
        } else { // POST, PUT, PATCH
            log.info("[{} URI={}, userId={}, PARAMETER={}, BODY={}]",
                    httpMethod,
                    requestURI,
                    CustomPrincipal.getId(),
                    request.getQueryString(),
                    getBody(wrapper));
        }

        return result;
    }

    private String getBody(ContentCachingRequestWrapper wrapper) throws UnsupportedEncodingException {
        if (wrapper == null)
            return "";

        byte[] buf = wrapper.getContentAsByteArray();
        if (buf.length == 0)
            return "";

        return new String(buf, wrapper.getCharacterEncoding());
    }
}
