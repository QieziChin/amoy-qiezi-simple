package com.amoy.service.admin.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.AuthRuleDao;
import com.amoy.service.admin.entity.AuthRuleEntity;
import com.amoy.service.admin.service.AuthRuleService;


@Service("authRuleService")
public class AuthRuleServiceImpl extends ServiceImpl<AuthRuleDao, AuthRuleEntity> implements AuthRuleService {

    @Override
    public PageUtil queryPage() {
        Map<String, Object> params = new HashMap<>();
        IPage<AuthRuleEntity> page = this.page(
                new Query<AuthRuleEntity>().getPage(params),
                new QueryWrapper<AuthRuleEntity>()
        );

        return new PageUtil(page);
    }

}