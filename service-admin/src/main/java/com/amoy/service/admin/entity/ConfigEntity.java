package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统配置
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-12 21:28:17
 */
@Data
@TableName("fa_config")
public class ConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 变量名
	 */
	private String name;
	/**
	 * 分组
	 */
	private String group;
	/**
	 * 变量标题
	 */
	private String title;
	/**
	 * 变量描述
	 */
	private String tip;
	/**
	 * 类型:string,text,int,bool,array,datetime,date,file
	 */
	private String type;
	/**
	 * 可见条件
	 */
	private String visible;
	/**
	 * 变量值
	 */
	private String value;
	/**
	 * 变量字典数据
	 */
	private String content;
	/**
	 * 验证规则
	 */
	private String rule;
	/**
	 * 扩展属性
	 */
	private String extend;
	/**
	 * 配置
	 */
	private String setting;
}
