package com.example.sens.util;

import lombok.Data;

@Data
public class Response<T> {

    private Integer code;

    private String msg;

    private T data;

    public Response() {
    }

    public Response(Integer code) {
        this.code = code;
    }

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> yes() {
        return new Response(0, "操作成功");
    }

    public static <T> Response<T> yes(String msg,T data) {
        return new Response(0, msg, data);
    }

    public static <T> Response<T> yes(T data) {
        return new Response(0, "操作成功", data);
    }


    public static <T> Response<T> no() {
        return new Response(-1, "操作失败");
    }

    public static <T> Response<T> no(String msg) {
        return new Response(-1, msg);
    }

}
