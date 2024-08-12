package com.amoy.service.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.amoy.common.utils.PageUtil;
import com.amoy.service.admin.entity.MoneyTypeEntity;

import java.util.Map;

/**
 * 
 *
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
public interface MoneyTypeService extends IService<MoneyTypeEntity> {

    PageUtil queryPage(Map<String, Object> params);
}

