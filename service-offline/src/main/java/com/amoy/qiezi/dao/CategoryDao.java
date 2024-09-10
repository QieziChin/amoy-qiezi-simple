package com.amoy.qiezi.dao;


import com.amoy.qiezi.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-09-05 23:39:57
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {

    @Select("select * from video_categories")
    List<CategoryEntity> listAll();

    @Update("update video_categories set total_videos=#{totalVideos}, today_videos=#{todayVideos} where cat_id=#{catId}")
    void updateStatistics(CategoryEntity category);
}
