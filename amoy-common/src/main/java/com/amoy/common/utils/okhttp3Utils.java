package com.amoy.common.utils;

import com.alibaba.fastjson2.JSONObject;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;

public class okhttp3Utils {

    public static Request get(String api, Map<String, String> header){
        Request.Builder builder = new Request.Builder().url(api);
        builder.addHeader("Content-Type", "application/json");

        header.forEach((key, value)->{
            builder.addHeader(key, value);
        });
        return builder.build();
    };

    public static Request post(String api, Map<String, String> header, JSONObject payload){
        RequestBody data = RequestBody.create(payload.toString(), MediaType.get("application/json"));
        Request.Builder builder = new Request.Builder().url(api);
        //请求JSON格式
        builder.addHeader("Content-Type", "application/json");
        header.forEach((key, value)->{
            builder.addHeader(key, value);
            builder.method("POST", data);
        });
        return builder.build();
    }
}
