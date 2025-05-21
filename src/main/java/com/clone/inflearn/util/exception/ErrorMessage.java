package com.clone.inflearn.util.exception;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class ErrorMessage {
    public String message;
    public LocalDateTime timestamp;

    public ErrorMessage(String message, LocalDateTime now) {
        this.message = message;
        this.timestamp = now;
    }
}
