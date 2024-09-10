package com.amoy.qiezi.dao;

import com.amoy.qiezi.entity.Page;
import com.amoy.qiezi.entity.VideoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-09-05 15:56:50
 */
@Mapper
public interface VideoDao extends BaseMapper<VideoEntity> {
    @Update("update video set thumb_url=#{thumbUrl} where video_id=#{videoId}")
    void updateThumb(VideoEntity video);

    @Select("select video_id, title, description from video where video_id between #{begin} and #{end}")
    List<VideoEntity> getPage(Page page);

}
