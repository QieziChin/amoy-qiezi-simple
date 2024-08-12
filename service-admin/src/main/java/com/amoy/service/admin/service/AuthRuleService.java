package com.amoy.service.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amoy.common.utils.PageUtil;
import com.amoy.service.admin.entity.AuthRuleEntity;

import java.util.Map;

/**
 * 节点表
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
public interface AuthRuleService extends IService<AuthRuleEntity> {

    PageUtil queryPage();
}

