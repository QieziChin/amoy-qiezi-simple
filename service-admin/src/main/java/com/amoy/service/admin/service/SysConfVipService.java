package com.amoy.service.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amoy.common.utils.PageUtil;
import com.amoy.service.admin.entity.SysConfVipEntity;

import java.util.Map;

/**
 * VIP 配置
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
public interface SysConfVipService extends IService<SysConfVipEntity> {

    PageUtil queryPage(Map<String, Object> params);
}

