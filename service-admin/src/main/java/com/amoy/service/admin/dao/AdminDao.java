package com.amoy.service.admin.dao;

import com.amoy.service.admin.entity.AdminEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 管理员表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Mapper
public interface AdminDao extends BaseMapper<AdminEntity> {


//    @Select("select * from fa_admin where username=#{username}")
//    AdminEntity findByUserName(String username);
}
