package org.sopt.sopkathon.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    NO_SUCH_USER_ERROR(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다."),

    /**
     * 공통 예외
     */
    NOT_SUPPORTED_METHOD_ERROR(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 HTTP 메서드입니다."),
    NOT_FOUND_ERROR(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "지원하지 않는 URL입니다."),
    NO_SUCH_PRODUCT_ERROR(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "존재하지 않는 상품입니다."),
    NOT_VALID_HEADER(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, "요청 헤더의 값이 잘못된 형식입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류 발생");

    private final boolean success;
    private final int code;
    private final HttpStatus status;
    private final String message;

    ErrorCode(int code, HttpStatus status, String message) {
        this.success = false;
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
