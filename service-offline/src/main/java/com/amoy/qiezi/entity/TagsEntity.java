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
 * @date 2024-09-05 19:59:43
 */
@Data
@TableName("tags")
public class TagsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer tagId;
	/**
	 * 
	 */
	private String tag;
	/**
	 * 
	 */
	private String autoTerms;
	/**
	 * 
	 */
	private Integer videos;
}
