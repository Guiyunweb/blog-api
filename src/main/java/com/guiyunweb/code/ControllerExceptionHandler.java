package com.guiyunweb.code;

import com.guiyunweb.exception.AuthException;
import com.guiyunweb.model.support.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wnkj
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ControllerExceptionHandler {


    @ExceptionHandler(value = AuthException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResponse defaultErrorHandler(AuthException e) {
        return BaseResponse.error(e.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Object> defaultExceptionHandler(HttpServletRequest request, Exception exception) {
        log.info("***********服务器繁忙**************");
        exception.printStackTrace();
        log.info("*********************************");
        return BaseResponse.error("服务器繁忙,请稍再试");
    }
}
