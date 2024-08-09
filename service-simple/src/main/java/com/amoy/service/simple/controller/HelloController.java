package com.amoy.service.simple.controller;


import com.amoy.common.utils.Result;

import com.amoy.common.entity.Draw;
import com.amoy.service.simple.utils.CollectUtils;
import com.amoy.service.simple.mapper.DrawMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("qiezi")
public class HelloController {

    @Value("${qiezi.message}")
    private String message;

    @Autowired
    DrawMapper drawMapper;

    @GetMapping("say")
    public Result hello(){
        return Result.success(message);
    }

    @PostMapping("task")
    public void testDrawJob(){
        List<Draw> list = drawMapper.task1();
        CollectUtils.bietnamDraw(drawMapper, list);
    }

    @PostMapping("task1")
    public String test1(String host, @RequestHeader("Authorization") String token){
        if ("5df686cd531a8bc9c3b339dd82f15874".equals(token)){
            return CollectUtils.routerCall(host);
        } else {
            return null;
        }
    }

    @GetMapping("article")
    public String getArticle(String host){
        return CollectUtils.getContent(host);
    }
}
