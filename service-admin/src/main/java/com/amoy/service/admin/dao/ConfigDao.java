package com.amoy.service.admin.dao;

import com.amoy.service.admin.entity.ConfigEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统配置
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Mapper
public interface ConfigDao extends BaseMapper<ConfigEntity> {
	
}
