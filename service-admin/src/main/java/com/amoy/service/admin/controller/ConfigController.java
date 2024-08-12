package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.ConfigEntity;
import com.amoy.service.admin.service.ConfigService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 系统配置
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = configService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		ConfigEntity config = configService.getById(id);

        return Result.success().put("config", config);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ConfigEntity config){
		configService.save(config);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ConfigEntity config){
		configService.updateById(config);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		configService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }

}
