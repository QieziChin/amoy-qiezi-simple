package com.amoy.qiezi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-09-05 22:05:53
 */
@Data
@TableName("video_fulltext")
public class FulltextEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer videoId;
	/**
	 * 
	 */
	private Integer orientation;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private Integer status;
}
