package com.luogh.consumer.service.commons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luogh
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public String exceptionHandler(Throwable e) {
        log.error(e.getMessage(), e);
        return e.getMessage();
    }

}
