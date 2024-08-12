package com.amoy.service.admin.dao;

import com.amoy.service.admin.entity.AuthRuleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 节点表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Mapper
public interface AuthRuleDao extends BaseMapper<AuthRuleEntity> {

    @Select("select * from fa_auth_rule where ismenu = 1 and status = 'normal' order by pid, weigh")
    List<AuthRuleEntity> listAll();
}
