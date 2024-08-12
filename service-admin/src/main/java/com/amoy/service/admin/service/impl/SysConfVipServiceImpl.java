package com.amoy.service.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.SysConfVipDao;
import com.amoy.service.admin.entity.SysConfVipEntity;
import com.amoy.service.admin.service.SysConfVipService;


@Service("sysConfVipService")
public class SysConfVipServiceImpl extends ServiceImpl<SysConfVipDao, SysConfVipEntity> implements SysConfVipService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        IPage<SysConfVipEntity> page = this.page(
                new Query<SysConfVipEntity>().getPage(params),
                new QueryWrapper<SysConfVipEntity>()
        );

        return new PageUtil(page);
    }

}