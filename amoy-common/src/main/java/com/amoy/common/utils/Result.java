package com.amoy.common.utils;

import lombok.Data;

import org.apache.http.HttpStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一响应结果
 */
@Data
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("timestamp", new Date());
        put("status", 200);
        put("msg", "success");
    }

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result success(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result success(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result success() {
        return new Result();
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.put("data", data);
        return result;
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
