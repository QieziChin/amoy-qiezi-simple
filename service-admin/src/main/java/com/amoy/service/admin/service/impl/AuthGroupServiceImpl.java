package com.amoy.service.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.AuthGroupDao;
import com.amoy.service.admin.entity.AuthGroupEntity;
import com.amoy.service.admin.service.AuthGroupService;


@Service("authGroupService")
public class AuthGroupServiceImpl extends ServiceImpl<AuthGroupDao, AuthGroupEntity> implements AuthGroupService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        IPage<AuthGroupEntity> page = this.page(
                new Query<AuthGroupEntity>().getPage(params),
                new QueryWrapper<AuthGroupEntity>()
        );

        return new PageUtil(page);
    }

}