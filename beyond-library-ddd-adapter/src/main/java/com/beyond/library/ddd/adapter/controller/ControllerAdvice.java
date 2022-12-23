package com.beyond.library.ddd.adapter.controller;

import com.beyond.exception.BizException;
import com.beyond.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author beyond
 * @since 2022/11/15
 */
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BizException.class)
    public Result<Void> handler(BizException e) {
        return Result.error(e.getCode(), e.getMessage());
    }
}
