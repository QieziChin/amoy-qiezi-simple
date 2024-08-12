package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.AdminLogEntity;
import com.amoy.service.admin.service.AdminLogService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 管理员日志表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/adminlog")
public class AdminLogController {
    @Autowired
    private AdminLogService adminLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = adminLogService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		AdminLogEntity adminLog = adminLogService.getById(id);

        return Result.success().put("adminLog", adminLog);
    }
}
