package com.amoy.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-12 21:28:16
 */
@Data
@TableName("fa_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 组别ID
	 */
	private Integer groupId;
	/**
	 * 账号
	 */
	private String account;
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
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 等级
	 */
	private Integer level;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 格言
	 */
	private String bio;
	/**
	 * 余额
	 */
	private BigDecimal money;
	/**
	 * 积分
	 */
	private Integer score;
	/**
	 * 连续登录天数
	 */
	private Integer successions;
	/**
	 * 最大连续登录天数
	 */
	private Integer maxsuccessions;
	/**
	 * 上次登录时间
	 */
	private Long prevtime;
	/**
	 * 登录时间
	 */
	private Long logintime;
	/**
	 * 登录IP
	 */
	private String loginip;
	/**
	 * 失败次数
	 */
	private Integer loginfailure;
	/**
	 * 加入IP
	 */
	private String joinip;
	/**
	 * 加入时间
	 */
	private Long jointime;
	/**
	 * Token
	 */
	private String token;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 验证
	 */
	private String verification;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Long createTime;
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Long updateTime;
}
