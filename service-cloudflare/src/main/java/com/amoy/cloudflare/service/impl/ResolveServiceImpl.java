package com.amoy.cloudflare.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.amoy.cloudflare.entity.Zone;
import com.amoy.cloudflare.service.ResolveService;
import okhttp3.*;
import okhttp3.OkHttpClient.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ResolveServiceImpl implements ResolveService {
    private String baseUrl = "https://api.CloudFlare.com/client/v4/zones%s";

    //内部数据获取地址
    @Value("${cloudflare.local.url}")
    private String local;
    //内部验证 远程服务的token 随意生成
    @Value("${cloudflare.local.secret}")
    private String secret;
    //Account ID
    @Value("${cloudflare.security.account.id}")
    private String id;
    //Account Email
    @Value("${cloudflare.security.account.email}")
    private String email;
    //API Keys
    @Value("${cloudflare.security.api.key}")
    private String key;
    //API Tokens
    @Value("${cloudflare.security.api.token}")
    private String token;

    /**
     * 新增Zone
     * @param domain
     */
    @Override
    public void addDomain(String domain) {
        String api = String.format(baseUrl, "");

        JSONObject data = new JSONObject();
        JSONObject account = new JSONObject();
        account.put("id", id);
        data.put("name", domain);
        data.put("type", "full");
        data.put("account", account);

        Builder Builder = new Builder();
        OkHttpClient okHttp = Builder.build();
        try (Response response = okHttp.newCall(this.postRequest(api, this.body(data.toString()))).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getZones(Zone zone){
        String api = String.format(baseUrl, "");
        String result = "";
        Builder Builder = new Builder();
        HttpUrl.Builder url = HttpUrl.parse(api).newBuilder();

        //默认不排序  看看取出来的数据会不会乱
        url.addQueryParameter("order", "name");
        url.addQueryParameter("page", String.valueOf(zone.getPage()));
        url.addQueryParameter("per_page", String.valueOf(zone.getPer_page()));

        // 构建完整的URL
        String fullAPi = url.build().toString();

        OkHttpClient okHttp = Builder.build();
        try (Response response = okHttp.newCall(getRequest(fullAPi)).execute()) {
            result = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return JSONObject.parse(result);
    }

    private Zone flip(Zone zone, JSONObject palyoad){
        palyoad.getJSONArray("result").forEach((item)->{
            JSONObject jZone = (JSONObject)item;
            zone.getMap().put(jZone.getString("name"), jZone.getString("id"));
            zone.getList().add(jZone.getString("name"));
        });
        if (zone.fuck()){
            zone.setPage(zone.getPage() + 1);
            flip(zone, getZones(zone));
        }

        return zone;
    }

    private void addDNS(){

    };
    @Override
    public void resolve() {
        JSONArray domain = getDomain();


        Zone page = new Zone();

        //先获取Zone 排除已添加过的Zone
        JSONObject palyoad = getZones(page);

        page.setTotal(palyoad.getJSONObject("result_info").getIntValue("total_count"));

        page = flip(page, palyoad);

        //先新增所有Zone
        for (int i=0; i < domain.size(); i++){
            String[] batchs = domain.getJSONObject(i).getString("resolve").split(";");
            for (int j=0; j < batchs.length; j++){
                String[] entity = batchs[j].split("\\|");
                //排除已经在列表中Zone
                if (page.getList().indexOf(entity[1])> -1) continue;
                //先调用添加域名
                if (entity[0].equals("@")) this.addDomain(entity[1]);
            }
        }

        for (int i=0; i < domain.size(); i++){
            String[] batchs = domain.getJSONObject(i).getString("resolve").split(";");
            for (int j=0; j < batchs.length; j++){
                String[] entity = batchs[j].split("\\|");


                //添加DNS
            }
        }
    }

    private JSONArray getDomain(){
        Builder Builder = new Builder();
        OkHttpClient okHttp = Builder.build();
        try (Response response = okHttp.newCall(this.postRequest(local, this.body(""))).execute()) {
            return JSONArray.parse(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Request postRequest(String api, RequestBody data){
        return new Request.Builder().url(api)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Auth-Email", email)
                .addHeader("X-Auth-Key", key)
                .addHeader("Q-Auth-Token", secret)
                .method("POST", data)
                .build();
    }

    private Request getRequest(String api){
        return new Request.Builder().url(api)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("X-Auth-Email", email)
                .addHeader("X-Auth-Key", key)
                .build();
    }

    private RequestBody body(String json){
        return RequestBody.create(json, MediaType.get("application/json"));
    }
}
