package com.zeng.repository.utils.exception;

public class ApiException extends Exception {
    private int status;//错误码
    private String msg;//错误信息

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.status = code;
    }

    public ApiException(int code, String msg) {
        this.status = code;
        this.msg = msg;
    }

    public int getCode() {
        return status;
    }

    public void setCode(int code) {
        this.status = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}