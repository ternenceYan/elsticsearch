package com.mooc.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mooc.enums.ErrorCode;
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CommonResult<T> {
    private long code;
    private String msg;
    private T data;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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
