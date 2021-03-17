package com.tany.membership.common;

import org.springframework.http.HttpStatus;

public class JSONResult<T> {
    private int status;

    private String msg;

    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(HttpStatus httpStatus) {
        this.status = httpStatus.value();
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

    public JSONResult() {
    }

    public JSONResult(HttpStatus httpStatus, String message, T data) {
        this.status = httpStatus.value();
        this.msg = message;
        this.data = data;
    }

    public static <T> JSONResult <T> success(String message ,T t)
    {
        return new JSONResult(HttpStatus.OK, message, t);
    }

    public static <T> JSONResult <T> success(T t)
    {
        return success("success", t);
    }

    public static <T> JSONResult success(String message)
    {
        return success(message,null);
    }

    public static <T> JSONResult <T> fail(String message, T t) {
        return new JSONResult(HttpStatus.INTERNAL_SERVER_ERROR, message, t);
    }

    public static JSONResult fail(String message) {
        return fail(message, null);
    }

    public static <T> JSONResult noAuth(String message) {
        return new JSONResult(HttpStatus.UNAUTHORIZED, message, null);
    }

}
