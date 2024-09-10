package com.amoy.qiezi.entity;

import com.alibaba.fastjson2.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer offset = 0;
    private Integer total = 0;
    private Integer begin = 0;
    private Integer end = 0;
    private Integer size = 100;
    private Integer page = 0;

    public boolean next(){
        page++;
        begin = size * (page - 1) + 1 + offset;
        end = size * page >= total ? total - begin : size * page + offset;
        return end - begin != 0;
    }

    public String toString(){
        return JSON.toJSONString(this);
    }
}
