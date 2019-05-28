package com.mooc.exceptions;

import com.mooc.enums.ErrorCode;

public class BaseException extends RuntimeException {
    private ErrorCode code;
    private String msg;

    public BaseException (ErrorCode code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(ErrorCode code) {
        this(code,code.getMsg());
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
