package com.cisdi.yard;

import com.cisdi.yard.consts.AppConsts;
import com.cisdi.yard.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result<Void> exceptionHandler(IllegalArgumentException e) {
        logger.error("argument error", e);
        return new Result<>(AppConsts.FAILED, e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<Void> exceptionHandler(Exception e) {
        logger.error("application error", e);
        return new Result<>(AppConsts.FAILED, AppConsts.FAILED_MSG);
    }
}