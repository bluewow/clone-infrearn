package com.clone.inflearn.util.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class ExceptionLogUtil {
    private static final String FORMAT = "[EXCEPTION] {} {} | Error:{} | Stack:{}";

    public static void logCustomException(CustomException ex, HttpServletRequest request) {
        LogLevel level = ex.getErrorCode().getLogLevel();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String errorCode = ex.getErrorCode().toString();
        String filteredStack = getFilteredStackTrace(ex);

        if (level == LogLevel.ERROR) {
            log.error(FORMAT, method, uri, errorCode, filteredStack);
        } else {
            log.warn(FORMAT, method, uri, errorCode, filteredStack);
        }
    }

    public static void logException(Exception ex, HttpServletRequest request) {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String message = ex.getMessage();
        String filteredStack = getFilteredStackTrace(ex);

        log.error(FORMAT, method, uri, message, filteredStack);
    }

    private static String getFilteredStackTrace(Throwable throwable) {
        StackTraceElement[] trace = throwable.getStackTrace();
        if (trace == null || trace.length == 0) {
            return "No stack trace available.";
        }

        return Arrays.stream(trace)
                .filter(el -> el.getClassName().contains("connect")) // 패키지 필터
                .limit(10)
                .map(StackTraceElement::toString)
                .collect(Collectors.joining(" | "));
    }
}
