package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.AuthRuleEntity;
import com.amoy.service.admin.service.AuthRuleService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 节点表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/authrule")
public class AuthRuleController {
    @Autowired
    private AuthRuleService authRuleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(){
        PageUtil page = authRuleService.queryPage();

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        AuthRuleEntity authRule = authRuleService.getById(id);
        return Result.success().put("authRule", authRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody AuthRuleEntity authRule){
        authRuleService.save(authRule);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody AuthRuleEntity authRule){
        authRuleService.updateById(authRule);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
        authRuleService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }
}
