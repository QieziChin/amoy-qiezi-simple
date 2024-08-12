package com.amoy.service.admin.service;

import com.alibaba.fastjson2.JSONArray;
import com.amoy.service.admin.form.LoginForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.amoy.common.utils.PageUtil;
import com.amoy.service.admin.entity.AdminEntity;

import java.util.Map;

/**
 * 管理员表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
public interface AdminService extends IService<AdminEntity> {

    PageUtil queryPage(Map<String, Object> params);

    AdminEntity findByUserName(String username);

    JSONArray getMenu(Integer id);
}

