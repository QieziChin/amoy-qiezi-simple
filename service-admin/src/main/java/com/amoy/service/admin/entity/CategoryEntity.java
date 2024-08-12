package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import lombok.Data;

/**
 * 分类表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Data
@TableName("fa_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 父ID
	 */
	private Integer pid;
	/**
	 * 栏目类型
	 */
	private String type;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private Set flag;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * 关键字
	 */
	private String keywords;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 自定义名称
	 */
	private String diyname;
	/**
	 * 创建时间
	 */
	private Long createtime;
	/**
	 * 更新时间
	 */
	private Long updatetime;
	/**
	 * 权重
	 */
	private Integer weigh;
	/**
	 * 状态
	 */
	private String status;

}
