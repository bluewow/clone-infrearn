package com.clone.inflearn.util.exception;

import com.clone.inflearn.util.dto.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { CustomException.class })
    protected ApiResponse<ErrorMessage> customException(CustomException ex) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        ExceptionLogUtil.logCustomException(ex, request);

        return ApiResponse.fail(ex.getErrorCode());
    }

    @ExceptionHandler(value = { Exception.class })
    protected ApiResponse<ErrorMessage> exception(Exception ex) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        ExceptionLogUtil.logException(ex, request);

        return ApiResponse.fail(ErrorCode.DEFAULT);
    }
}
