package com.amoy.qiezi.dao;

import com.amoy.qiezi.entity.TagsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-09-05 19:59:43
 */
@Mapper
public interface TagsDao extends BaseMapper<TagsEntity> {

    @Select("select * from tags")
    List<TagsEntity> listAll();
}
