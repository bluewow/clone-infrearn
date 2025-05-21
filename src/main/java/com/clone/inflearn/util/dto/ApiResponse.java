package com.clone.inflearn.util.dto;

import com.clone.inflearn.util.exception.ErrorCode;
import com.clone.inflearn.util.exception.ErrorMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
public class ApiResponse<T> extends ResponseEntity<T> {

    public ApiResponse(@Nullable T body, HttpStatus status) {
        super(body, status);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(null, HttpStatus.OK);
    }

    public static <T> ApiResponse<T> success(T body) {
        return new ApiResponse<>(body, HttpStatus.OK);
    }

    public static ApiResponse<ErrorMessage> fail(ErrorCode errorCode) {
        ErrorMessage errorMessage = new ErrorMessage(errorCode.getMessage(), LocalDateTime.now());
        return new ApiResponse<>(errorMessage, HttpStatus.valueOf(errorCode.getStatus()));
    }

}
