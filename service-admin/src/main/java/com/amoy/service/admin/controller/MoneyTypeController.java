package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson2.JSONArray;
import com.amoy.common.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("admin/money")
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
        Map<String, Object> map = ThreadLocalUtil.get();
        moneyType.setOperater((Integer) map.get("id"));
        moneyType.setStatus("0");
		moneyTypeService.save(moneyType);
        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody MoneyTypeEntity moneyType){
        Map<String, Object> map = ThreadLocalUtil.get();
        moneyType.setOperater((Integer) map.get("id"));
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

    @PostMapping ("/state")
    public Result state(@RequestBody MoneyTypeEntity moneyType){
        moneyTypeService.updateState(moneyType);
        return Result.success();
    }
}
