package com.amoy.qiezi.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.amoy.common.utils.okhttp3Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;

import java.io.IOException;
import java.util.HashMap;

import static com.amoy.common.utils.Constant.agent;

@Service("cloudflare")
public class CloudflareService extends TranslateServiceImpl {


    @Value("${cloudflare.security.url}")
    private String api;

    @Value("${cloudflare.security.key}")
    private String secretKey;

    @Value("${cloudflare.security.cookie}")
    private String cookie;
    @Override
    public String translate(String content, String target, String source) {

        HttpUrl.Builder url = HttpUrl.parse(api).newBuilder();

        //默认不排序  看看取出来的数据会不会乱
        url.addQueryParameter("text", content);
        url.addQueryParameter("source_language", "en");
        url.addQueryParameter("target_language", target);
        url.addQueryParameter("secret", secretKey);

        // 构建完整的URL
        String fullAPi = url.build().toString();

        Builder Builder = new Builder();
        OkHttpClient okHttp = Builder.build();

        HashMap<String, String> header = new HashMap<>();
        header.put("User-Agent", agent);
        try (Response response = okHttp.newCall(okhttp3Utils.get(fullAPi, header)).execute()) {
            String payload = response.body().string();
            JSONObject result = JSONObject.parse(payload);
            if (result.getString("msg").equals("ok")){
                return result.getString("text");
            } else {
                logger.info("翻译错误 - target: {}，text: {}, message: {}", target, content, result);
                throw new RuntimeException(fullAPi);
            }
        } catch (IOException e) {
            throw new RuntimeException(fullAPi);
        }
    }
}
