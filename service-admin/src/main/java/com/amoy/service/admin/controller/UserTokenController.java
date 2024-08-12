package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.UserTokenEntity;
import com.amoy.service.admin.service.UserTokenService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 会员Token表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/usertoken")
public class UserTokenController {
    @Autowired
    private UserTokenService userTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = userTokenService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{token}")
    public Result info(@PathVariable("token") String token){
		UserTokenEntity userToken = userTokenService.getById(token);

        return Result.success().put("userToken", userToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody UserTokenEntity userToken){
		userTokenService.save(userToken);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody UserTokenEntity userToken){
		userTokenService.updateById(userToken);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody String[] tokens){
		userTokenService.removeByIds(Arrays.asList(tokens));

        return Result.success();
    }

}
