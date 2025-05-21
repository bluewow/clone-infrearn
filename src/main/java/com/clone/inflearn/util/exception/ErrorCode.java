package com.clone.inflearn.util.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

import static org.springframework.boot.logging.LogLevel.ERROR;
import static org.springframework.boot.logging.LogLevel.WARN;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DEFAULT("시스템 에러 입니다", ERROR, HttpStatus.INTERNAL_SERVER_ERROR), // 500: 서버 내부 에러
    DUPLICATE("중복된 값입니다", ERROR, HttpStatus.INTERNAL_SERVER_ERROR), // 400: 잘못된 요청
    ALREADY("이미 존재하는 값입니다", WARN, HttpStatus.INTERNAL_SERVER_ERROR), // 500: 서버 내부 에러
    FILE_NOT_MATCH("파일 형식이 일치하지 않습니다", WARN, HttpStatus.BAD_REQUEST), // 400: 잘못된 요청
    AUTH("유효하지 않은 유저입니다", WARN, HttpStatus.UNAUTHORIZED), // 401: 인증 실패
    JWT_EXPIRED("만료된 토큰입니다", WARN, HttpStatus.UNAUTHORIZED), // 401: 인증 실패
    PASSWORD("비밀번호가 일치하지 않습니다", WARN, HttpStatus.UNAUTHORIZED), // 401: 인증 실패
    JSON("JSON 파싱 에러입니다", ERROR, HttpStatus.BAD_REQUEST), // 400: 잘못된 요청
    NOT_FOUND("존재하지 않는 리소스입니다", ERROR, HttpStatus.NOT_FOUND), // 404: 리소스 없음
    INVALID_PARAM("잘못된 요청입니다", ERROR, HttpStatus.BAD_REQUEST), // 400: 잘못된 요청
    INVALID_ACCESS("유효하지 않은 접근입니다", ERROR, HttpStatus.FORBIDDEN); // 403: 접근 권한 없음

    private final String message;
    private final LogLevel logLevel;
    private final HttpStatus status;

    public Integer getStatus() {
        return this.status.value();
    }
}
