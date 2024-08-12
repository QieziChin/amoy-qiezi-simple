package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 分组表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Data
@TableName("fa_auth_group")
public class AuthGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 父组别
	 */
	private Integer pid;
	/**
	 * 组名
	 */
	private String name;
	/**
	 * 规则ID
	 */
	private String rules;
	/**
	 * 创建时间
	 */
	private Long createtime;
	/**
	 * 更新时间
	 */
	private Long updatetime;
	/**
	 * 状态
	 */
	private String status;

}
