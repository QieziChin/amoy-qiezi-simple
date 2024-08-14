package com.amoy.service.admin.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson2.JSONArray;
import com.amoy.common.utils.*;
import com.amoy.common.validator.ValidatorUtils;
import com.amoy.service.admin.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import com.amoy.service.admin.entity.AdminEntity;
import com.amoy.service.admin.service.AdminService;


/**
 * 管理员表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtil page = adminService.queryPage(params);

        return Result.success().put("page", page);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
		AdminEntity admin = adminService.getById(id);
        return Result.success().put("admin", admin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody AdminEntity admin){
		adminService.save(admin);
        return Result.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody AdminEntity admin){
		adminService.updateById(admin);
        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids){
		adminService.removeByIds(Arrays.asList(ids));

        return Result.success();
    }

    @RequestMapping("/getMenu")
    public Result getMenu(){
        Map<String, Object> map = ThreadLocalUtil.get();
        JSONArray data = adminService.getMenu((Integer) map.get("id"));
        return Result.success().put("data", data);
    }

    @PostMapping("login")
    public Result login(@RequestBody LoginForm form){
        //验证表单
        ValidatorUtils.validateEntity(form);

        AdminEntity user = adminService.findByUserName(form.getUsername());

        if (user == null){
            return Result.error("用户名错误");
        }

        if (MD5Util.getMD5SaltString(form.getPassword(), user.getSalt()).equals(user.getPassword())){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());
            String token = JwtUtil.getToken(claims);
            //
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token, 1, TimeUnit.HOURS);
            return Result.success().put("data", JwtUtil.getToken(claims));
        }
        return Result.error("密码错误！");
    }



}
