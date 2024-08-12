package com.amoy.service.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amoy.common.utils.PageUtil;
import com.amoy.service.admin.entity.AttachmentEntity;

import java.util.Map;

/**
 * 附件表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
public interface AttachmentService extends IService<AttachmentEntity> {

    PageUtil queryPage(Map<String, Object> params);
}

