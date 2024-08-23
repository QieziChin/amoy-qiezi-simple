package com.amoy.cloudflare.entity;

import com.amoy.cloudflare.api.Meili;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Zone implements Meili {
    //总记录数
    private int total = 0;
    //当前页数
    private int page = 1;
    //每页数量 max 50
    private int per_page = 50;

    //创建一个域名数组 用来做后续的查询
    List<String> list;
    //建立Zone 和 Zone id 映射 用于域名解析
    Map<String, String> map;

    @Override
    public boolean fuck(){
        return this.page * this.per_page < total;
    }

    public Zone(){
        list = new ArrayList<>();
        map = new HashMap<>();
    }
}
