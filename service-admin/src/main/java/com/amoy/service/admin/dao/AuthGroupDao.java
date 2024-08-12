package com.amoy.service.admin.dao;

import com.amoy.service.admin.entity.AuthGroupEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 分组表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Mapper
public interface AuthGroupDao extends BaseMapper<AuthGroupEntity> {

    @Select("select b.* from fa_auth_group_access a left join fa_auth_group b on a.group_id = b.id where a.uid=#{uid}")
    AuthGroupEntity findById(Integer uid);
}
