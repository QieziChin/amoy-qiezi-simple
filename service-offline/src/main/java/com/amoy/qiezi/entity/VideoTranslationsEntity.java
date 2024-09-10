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
 * @date 2024-09-07 17:59:02
 */
@Data
@TableName("video_translations")
public class VideoTranslationsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer videoId;
	/**
	 * 
	 */
	private Integer langId;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String description;
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
	/**
	 * 
	 */
	private String custom1;
	/**
	 * 
	 */
	private String custom2;
	/**
	 * 
	 */
	private String custom3;
}
