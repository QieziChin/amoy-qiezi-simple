package com.amoy.service.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.MoneyTypeDao;
import com.amoy.service.admin.entity.MoneyTypeEntity;
import com.amoy.service.admin.service.MoneyTypeService;


@Service("moneyTypeService")
public class MoneyTypeServiceImpl extends ServiceImpl<MoneyTypeDao, MoneyTypeEntity> implements MoneyTypeService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        IPage<MoneyTypeEntity> page = this.page(
                new Query<MoneyTypeEntity>().getPage(params),
                new QueryWrapper<MoneyTypeEntity>()
        );

        return new PageUtil(page);
    }

}