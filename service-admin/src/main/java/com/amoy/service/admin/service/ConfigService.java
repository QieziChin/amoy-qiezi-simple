package com.amoy.service.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amoy.common.utils.PageUtil;
import com.amoy.service.admin.entity.ConfigEntity;

import java.util.Map;

/**
 * 系统配置
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
public interface ConfigService extends IService<ConfigEntity> {

    PageUtil queryPage(Map<String, Object> params);
}

