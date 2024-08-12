package com.amoy.service.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.ConfigDao;
import com.amoy.service.admin.entity.ConfigEntity;
import com.amoy.service.admin.service.ConfigService;


@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        IPage<ConfigEntity> page = this.page(
                new Query<ConfigEntity>().getPage(params),
                new QueryWrapper<ConfigEntity>()
        );

        return new PageUtil(page);
    }

}