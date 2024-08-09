package com.amoy.service.simple.controller;


import com.amoy.common.entity.Draw;
import com.amoy.common.utils.Result;
import com.amoy.service.simple.service.VietnamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vietnam")
public class VietnamController {

    @Autowired
    private VietnamService vietnamService;



    @PostMapping("/draw")
    public Result getDraw(String page){

        Draw draw = vietnamService.findByPage(page);

        return Result.success(draw);
    }
}
