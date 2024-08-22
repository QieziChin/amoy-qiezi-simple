package com.amoy.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典管理
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-16 13:09:31
 */
@Data
@TableName("fa_sys_conf_dic")
public class DicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String item;
	/**
	 * 
	 */
	private Integer itemValue;
	/**
	 * 
	 */
	private String itemDesc;
}
