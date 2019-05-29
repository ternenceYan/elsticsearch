package com.mooc.result;

import com.mooc.enums.ErrorCode;

public class CommonResult<T> {
    private long code;
    private String msg;
    private T data;

    public CommonResult () {

    }
    public CommonResult (long code) {
        this.code = code;
    }
    public CommonResult (long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult (long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMsg(),data);
    }

    public static<T> CommonResult<T> error (T data) {
        return new CommonResult<T>(ErrorCode.FAIL.getCode(),ErrorCode.FAIL.getMsg(),data);
    }

    public CommonResult fail (ErrorCode code) {
        return new CommonResult(ErrorCode.FAIL.getCode(),ErrorCode.FAIL.getMsg(),null);
    }
}
