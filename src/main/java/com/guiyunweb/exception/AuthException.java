package com.guiyunweb.exception;

import org.springframework.http.HttpStatus;

/**
 * 认证错误
 *
 * @author wnkj
 */
public class AuthException extends BaseException {

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

}
