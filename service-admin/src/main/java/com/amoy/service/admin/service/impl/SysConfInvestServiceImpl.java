package com.amoy.service.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.SysConfInvestDao;
import com.amoy.service.admin.entity.SysConfInvestEntity;
import com.amoy.service.admin.service.SysConfInvestService;


@Service("sysConfInvestService")
public class SysConfInvestServiceImpl extends ServiceImpl<SysConfInvestDao, SysConfInvestEntity> implements SysConfInvestService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        IPage<SysConfInvestEntity> page = this.page(
                new Query<SysConfInvestEntity>().getPage(params),
                new QueryWrapper<SysConfInvestEntity>()
        );

        return new PageUtil(page);
    }

}