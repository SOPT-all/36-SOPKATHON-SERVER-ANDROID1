package org.sopt.sopkathon.global.result;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ResultResponse<T>(boolean success, int code, String message, @JsonInclude(JsonInclude.Include.NON_NULL) T data) {

    public static <T> ResultResponse<T> of(ResultCode resultCode, T data){
        return new ResultResponse<>(resultCode.isSuccess(), resultCode.getCode(), resultCode.getMessage(), data);
    }
}
