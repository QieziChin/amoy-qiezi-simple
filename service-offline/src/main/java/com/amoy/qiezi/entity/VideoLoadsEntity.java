package com.amoy.qiezi.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-09-06 15:04:47
 */
@Data
@TableName("video_loads")
public class VideoLoadsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer videoId;
	/**
	 * 
	 */
	private Long totalLoads;
	/**
	 * 
	 */
	private Integer todayLoads;
}
