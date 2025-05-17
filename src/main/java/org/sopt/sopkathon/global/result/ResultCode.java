package org.sopt.sopkathon.global.result;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResultCode {

    CREATED(HttpStatus.CREATED.value(), HttpStatus.CREATED, "리소스를 생성했습니다."),
    SUCCESS(HttpStatus.OK.value(), HttpStatus.OK, "요청이 성공했습니다.");

    private final boolean success;
    private final int code;
    private final HttpStatus status;
    private final String message;

    ResultCode(int code, HttpStatus status, String message) {
        this.success = true;
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
