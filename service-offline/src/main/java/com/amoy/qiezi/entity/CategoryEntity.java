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
 * @date 2024-09-05 23:39:57
 */
@Data
@TableName("video_categories")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer catId;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private Integer orientation;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String slug;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String autoTerms;
	/**
	 * 
	 */
	private String ext;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String metaTitle;
	/**
	 * 
	 */
	private String metaDesc;
	/**
	 * 
	 */
	private String metaKeys;

	private Integer totalVideos;
	private Integer todayVideos;
}
