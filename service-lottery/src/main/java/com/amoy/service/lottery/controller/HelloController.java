package com.amoy.service.lottery.controller;

import com.amoy.common.api.SimpleFeignApi;
import com.amoy.common.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Resource
    SimpleFeignApi simpleFeignApi;
    @GetMapping("/meili/test")
    public Result feignTest(){
        Result result = simpleFeignApi.hello();
        return Result.success(result);
    }
    @GetMapping("/qiezi/fuck/{name}")
    public Result fuckMeili(@PathVariable("name") String name){
        return Result.success("fuck " + name);
    }

    @GetMapping(value = "/qiezi/info")
    public String getInfo(){
        return simpleFeignApi.getInfo();
    }
}
