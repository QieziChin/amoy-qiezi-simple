package com.amoy.service.admin.dao;

import com.amoy.service.admin.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分类表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
