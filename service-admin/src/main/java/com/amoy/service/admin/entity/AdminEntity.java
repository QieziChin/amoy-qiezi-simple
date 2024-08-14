package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 管理员表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-12 21:28:16
 */
@Data
@TableName("fa_admin")
public class AdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 密码盐
	 */
	private String salt;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 失败次数
	 */
	private Integer loginfailure;
	/**
	 * 登录时间
	 */
	private Long logintime;
	/**
	 * 登录IP
	 */
	private String loginip;
	/**
	 * 创建时间
	 */
	@TableField(value = "createtime", fill = FieldFill.INSERT)
	private Long createtime;
	/**
	 * 更新时间
	 */
	@TableField(value = "updatetime", fill = FieldFill.UPDATE)
	private Long updatetime;
	/**
	 * Session标识
	 */
	private String token;
	/**
	 * 状态
	 */
	private String status;
}
