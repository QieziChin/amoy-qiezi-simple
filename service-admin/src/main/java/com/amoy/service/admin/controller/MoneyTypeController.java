package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoy.service.admin.entity.MoneyTypeEntity;
import com.amoy.service.admin.service.MoneyTypeService;
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
@RequestMapping("admin/moneytype")
public class MoneyTypeController {
    @Autowired
    private MoneyTypeService moneyTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = moneyTypeService.queryPage(params);

        return Result.success().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		MoneyTypeEntity moneyType = moneyTypeService.getById(id);

        return Result.success().put("moneyType", moneyType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody MoneyTypeEntity moneyType){
		moneyTypeService.save(moneyType);

        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody MoneyTypeEntity moneyType){
		moneyTypeService.updateById(moneyType);

        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		moneyTypeService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }

}
