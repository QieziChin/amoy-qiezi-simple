package com.amoy.service.simple.mapper;


import com.amoy.common.entity.Draw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DrawMapper {

    @Select("select * from vietnam where page=#{page}")
    Draw findByPage(String page);

    @Select("select * from task2")
    List<Draw> list();


    @Select("select * from task1")
    List<Draw> task1();

    @Update("update vietnam set content=#{content}, update_time=#{updateTime} where id=#{id}")
    void update(Draw draw);
}
