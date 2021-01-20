package com.tany.membership.common;

import org.springframework.http.HttpStatus;

public class JSONResult {
    private int status;

    private String msg;

    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSONResult(){}

    public JSONResult(HttpStatus httpStatus,String message,Object data) {
        this.status = httpStatus.value();
        this.msg = message;
        this.data = data;
    }

    public static <T> JSONResult ok(T t) {
        return new JSONResult(HttpStatus.OK,"ok",t);
    }
    public static JSONResult error(String message) {
        return new JSONResult(HttpStatus.INTERNAL_SERVER_ERROR,message,null);
    }
    public static <T> JSONResult error(String message,T t) {
        return new JSONResult(HttpStatus.INTERNAL_SERVER_ERROR,message,t);
    }
    public static <T> JSONResult noAuth(String message) {
        return new JSONResult(HttpStatus.UNAUTHORIZED,message,null);
    }
	
}
