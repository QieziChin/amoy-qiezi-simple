package com.amoy.service.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.AuthGroupAccessDao;
import com.amoy.service.admin.entity.AuthGroupAccessEntity;
import com.amoy.service.admin.service.AuthGroupAccessService;


@Service("authGroupAccessService")
public class AuthGroupAccessServiceImpl extends ServiceImpl<AuthGroupAccessDao, AuthGroupAccessEntity> implements AuthGroupAccessService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        IPage<AuthGroupAccessEntity> page = this.page(
                new Query<AuthGroupAccessEntity>().getPage(params),
                new QueryWrapper<AuthGroupAccessEntity>()
        );

        return new PageUtil(page);
    }

}