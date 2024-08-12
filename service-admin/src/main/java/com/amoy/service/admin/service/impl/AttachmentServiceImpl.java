package com.amoy.service.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amoy.common.utils.PageUtil;
import com.amoy.common.utils.Query;

import com.amoy.service.admin.dao.AttachmentDao;
import com.amoy.service.admin.entity.AttachmentEntity;
import com.amoy.service.admin.service.AttachmentService;


@Service("attachmentService")
public class AttachmentServiceImpl extends ServiceImpl<AttachmentDao, AttachmentEntity> implements AttachmentService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        IPage<AttachmentEntity> page = this.page(
                new Query<AttachmentEntity>().getPage(params),
                new QueryWrapper<AttachmentEntity>()
        );

        return new PageUtil(page);
    }

}