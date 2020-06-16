package com.guiyunweb.code;

import com.guiyunweb.exception.AuthException;
import com.guiyunweb.model.support.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author wnkj
 */
@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(value = AuthException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public BaseResponse defaultErrorHandler(AuthException e) {
        System.out.println("***********服务器繁忙**************");
        return BaseResponse.error(e.getMessage());
    }


}
