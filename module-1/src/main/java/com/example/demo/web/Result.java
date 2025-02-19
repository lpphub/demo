package com.example.demo.web;

import lombok.Getter;

@Getter
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.data = data;
        result.msg = "ok";
        return result;
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> fail(int code, String msg) {
        Result<T> result = new Result<>();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static <T> Result<T> fail(BizException e) {
        Result<T> result = new Result<>();
        result.code = e.getCode();
        result.msg = e.getMsg();
        return result;
    }
}
