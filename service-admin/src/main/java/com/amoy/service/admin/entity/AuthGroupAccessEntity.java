package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限分组表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-12 21:28:17
 */
@Data
@TableName("fa_auth_group_access")
public class AuthGroupAccessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 会员ID
	 */
	@TableId
	private Integer uid;
	/**
	 * 级别ID
	 */
	private Integer groupId;
}
