package com.geekaca.stc.utils;

public class Result {
    private Integer code;
    private Object date;
    private  String msg;

    public Result(Integer code, Object date, String msg) {
        this.code = code;
        this.date = date;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
