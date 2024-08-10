package com.amoy.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结果
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6258345321767540526L;

    private final Integer code;//业务状态
    private final String message;//提示信息
    private final T data;//响应数据

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
        this((T) null);
    }

    public Result(T data) {
        this(Info.SUCCESS.getCode(), Info.SUCCESS.getMsg(), data);
    }

    public Result(Integer code, String message) {
        this(code, message, (T) null);
    }

//    public Result put(String key, Object data) {
//
//    }

    public static <T> Result<T> success() {
        return new Result();
    }

    public static <T> Result<T> success(T data) {
        return new Result(data);
    }

    public static Result<String> failure(String message) {
        return new Result(Info.SERVER_ERROR.getCode(), message);
    }

    public static <T> Result<T> failure(Info errorCode) {
        return new Result(errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> Result<T> failure(Info errorCode, T data) {
        return new Result(errorCode.getCode(), errorCode.getMsg(), data);
    }

    public String toString() {
        return "Result{errorCode=" + this.code + ", message='" + this.message + '\'' + ", data=" + this.data + '}';
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

}
