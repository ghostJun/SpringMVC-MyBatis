package com.zealot.base;

/**
 * Created by GhostJun on 16/8/23.
 */
public class ResponseData {
    private Object code;

    private String message;

    private Object data;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
