package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.UserMoneyLogEntity;
import com.amoy.service.admin.service.UserMoneyLogService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 会员余额变动表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/usermoneylog")
public class UserMoneyLogController {
    @Autowired
    private UserMoneyLogService userMoneyLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = userMoneyLogService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		UserMoneyLogEntity userMoneyLog = userMoneyLogService.getById(id);

        return Result.success().put("userMoneyLog", userMoneyLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody UserMoneyLogEntity userMoneyLog){
		userMoneyLogService.save(userMoneyLog);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody UserMoneyLogEntity userMoneyLog){
		userMoneyLogService.updateById(userMoneyLog);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		userMoneyLogService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }

}
