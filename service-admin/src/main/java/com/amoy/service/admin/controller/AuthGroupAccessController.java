package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.AuthGroupAccessEntity;
import com.amoy.service.admin.service.AuthGroupAccessService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 权限分组表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/authgroupaccess")
public class AuthGroupAccessController {
    @Autowired
    private AuthGroupAccessService authGroupAccessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = authGroupAccessService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uid}")
    public Result info(@PathVariable("uid") Integer uid){
		AuthGroupAccessEntity authGroupAccess = authGroupAccessService.getById(uid);

        return Result.success().put("authGroupAccess", authGroupAccess);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody AuthGroupAccessEntity authGroupAccess){
		authGroupAccessService.save(authGroupAccess);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody AuthGroupAccessEntity authGroupAccess){
		authGroupAccessService.updateById(authGroupAccess);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] uids){
		authGroupAccessService.removeByIds(Arrays.asList(uids));

        return Result.success();
    }

}
