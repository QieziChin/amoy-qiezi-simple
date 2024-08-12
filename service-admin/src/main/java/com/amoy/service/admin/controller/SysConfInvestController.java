package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.SysConfInvestEntity;
import com.amoy.service.admin.service.SysConfInvestService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 投资配置
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/sysconfinvest")
public class SysConfInvestController {
    @Autowired
    private SysConfInvestService sysConfInvestService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = sysConfInvestService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		SysConfInvestEntity sysConfInvest = sysConfInvestService.getById(id);

        return Result.success().put("sysConfInvest", sysConfInvest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody SysConfInvestEntity sysConfInvest){
		sysConfInvestService.save(sysConfInvest);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SysConfInvestEntity sysConfInvest){
		sysConfInvestService.updateById(sysConfInvest);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		sysConfInvestService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }

}
