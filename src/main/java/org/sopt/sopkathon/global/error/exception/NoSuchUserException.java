package org.sopt.sopkathon.global.error.exception;

import org.sopt.sopkathon.global.error.ErrorCode;

public class NoSuchUserException extends BusinessException{
    public NoSuchUserException() {
        super(ErrorCode.NO_SUCH_USER_ERROR);
    }
}
