package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.VersionEntity;
import com.amoy.service.admin.service.VersionService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 版本表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/version")
public class VersionController {
    @Autowired
    private VersionService versionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = versionService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		VersionEntity version = versionService.getById(id);

        return Result.success().put("version", version);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody VersionEntity version){
		versionService.save(version);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody VersionEntity version){
		versionService.updateById(version);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		versionService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }

}
