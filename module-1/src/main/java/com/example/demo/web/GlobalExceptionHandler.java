package com.example.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
@Order(1)
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public Result<?> handleException(BizException be) {
        return Result.fail(be);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<?> handle404(NoResourceFoundException e) {
        return Result.fail(404, "resource no found");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleArgsException(MethodArgumentNotValidException e) {
        return Result.fail(1000, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error("server error", e);
        return Result.fail(new BizException(-1, e.getMessage()));
    }


}
