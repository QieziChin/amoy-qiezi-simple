package com.amoy.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Draw {

    private Integer id; //主键id
    private String name;
    private String page;
    private String style;
    private String url;
    private String content;
    @JsonFormat
    private LocalDateTime updateTime;//更新时间
}
