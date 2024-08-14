package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amoy.service.admin.entity.AuthGroupEntity;
import com.amoy.service.admin.service.AuthGroupService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 分组表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/role")
public class AuthGroupController {
    @Autowired
    private AuthGroupService authGroupService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = authGroupService.queryPage(params);
        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		AuthGroupEntity authGroup = authGroupService.getById(id);

        return Result.success().put("authGroup", authGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody AuthGroupEntity authGroup){
		authGroupService.save(authGroup);
        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody AuthGroupEntity authGroup){
		authGroupService.updateById(authGroup);
        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @DeleteMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		authGroupService.removeByIds(Arrays.asList(ids));
        return Result.success();
    }

}
