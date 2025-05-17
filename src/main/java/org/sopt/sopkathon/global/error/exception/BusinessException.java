package org.sopt.sopkathon.global.error.exception;

import lombok.Getter;
import org.sopt.sopkathon.global.error.ErrorCode;

@Getter
public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
