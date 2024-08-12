package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.ContentHelpEntity;
import com.amoy.service.admin.service.ContentHelpService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/contenthelp")
public class ContentHelpController {
    @Autowired
    private ContentHelpService contentHelpService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = contentHelpService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		ContentHelpEntity contentHelp = contentHelpService.getById(id);

        return Result.success().put("contentHelp", contentHelp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ContentHelpEntity contentHelp){
		contentHelpService.save(contentHelp);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ContentHelpEntity contentHelp){
		contentHelpService.updateById(contentHelp);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		contentHelpService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }

}
