package com.mooc.enums;

public enum ErrorCode {
    SUCCESS(1000, "成功"),
    FAIL(1001, "失败"),
    JSON_ERROR(1002,"JSON转换异常！"),
    FILE_ERROR(1003,"文件接收异常！");
    private Integer code;
    private String msg;
    ErrorCode (Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
