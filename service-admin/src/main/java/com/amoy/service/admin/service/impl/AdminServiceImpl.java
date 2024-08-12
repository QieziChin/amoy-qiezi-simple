package com.amoy.service.admin.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.amoy.common.exception.QException;
import com.amoy.common.utils.MD5Util;
import com.amoy.common.validator.Assert;
import com.amoy.service.admin.dao.AuthGroupDao;
import com.amoy.service.admin.dao.AuthRuleDao;
import com.amoy.service.admin.entity.AuthGroupEntity;
import com.amoy.service.admin.entity.AuthRuleEntity;
import com.amoy.service.admin.form.LoginForm;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.AdminDao;
import com.amoy.service.admin.entity.AdminEntity;
import com.amoy.service.admin.service.AdminService;


@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {


    @Autowired
    AuthGroupDao authGroupDao;

    @Autowired
    AuthRuleDao authRuleDao;
    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        IPage<AdminEntity> page = this.page(
                new Query<AdminEntity>().getPage(params),
                new QueryWrapper<AdminEntity>()
        );

        return new PageUtil(page);
    }

    @Override
    public AdminEntity findByUserName(String username) {
        return baseMapper.selectOne(new QueryWrapper<AdminEntity>().eq("username", username));
    }

    private JSONArray recursive(List<AuthRuleEntity> items, Integer pid){
        JSONArray array = new JSONArray();
        for (AuthRuleEntity item : items) {
            if (item.getPid().equals(pid)){
                JSONObject obj = new JSONObject();
                obj.put("id", item.getName());
                obj.put("icon", item.getIcon());
                obj.put("title", item.getTitle());
                JSONArray child = recursive(items, item.getId());
                if (child.size() > 0){
                    obj.put("children", child);
                }
                array.add(obj);
            }
        }
        return array;
    }
    @Override
    public JSONArray getMenu(Integer id) {
        //先找到权限组
        AuthGroupEntity auth = authGroupDao.findById(id);
        JSONArray result;
        //判断如果是 * 则加载全部菜单，否则之加载
        if (auth.getRules().equals("*")){
            List<AuthRuleEntity> list = authRuleDao.listAll();
            result = recursive(list, 0);
        } else {
            List<AuthRuleEntity> list = authRuleDao.listAll();
            result = recursive(list, 0);
        }
        return result;
    }

}