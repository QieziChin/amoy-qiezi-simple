package com.amoy.service.admin.controller;


import com.amoy.common.entity.Draw;
import com.amoy.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("meili")
public class HelloController {

    @Value("${qiezi.message}")
    private String message;


    @GetMapping("say")
    public Result hello(){
        return Result.success(message);
    }
}
