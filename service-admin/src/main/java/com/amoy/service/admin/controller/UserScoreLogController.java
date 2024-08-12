package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.UserScoreLogEntity;
import com.amoy.service.admin.service.UserScoreLogService;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Result;



/**
 * 会员积分变动表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin/userscorelog")
public class UserScoreLogController {
    @Autowired
    private UserScoreLogService userScoreLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = userScoreLogService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		UserScoreLogEntity userScoreLog = userScoreLogService.getById(id);

        return Result.success().put("userScoreLog", userScoreLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody UserScoreLogEntity userScoreLog){
		userScoreLogService.save(userScoreLog);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody UserScoreLogEntity userScoreLog){
		userScoreLogService.updateById(userScoreLog);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		userScoreLogService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }

}
