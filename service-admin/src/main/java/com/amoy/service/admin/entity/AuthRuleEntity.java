package com.amoy.service.admin.entity;

import com.amoy.service.admin.emums.AuthType;
import com.amoy.service.admin.emums.MenuType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 节点表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Data
@TableName("fa_auth_rule")
public class AuthRuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * menu为菜单,file为权限节点
	 */
	private AuthType type;
	/**
	 * 父ID
	 */
	private Integer pid;
	/**
	 * 规则名称
	 */
	private String name;
	/**
	 * 规则名称
	 */
	private String title;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 规则URL
	 */
	private String url;
	/**
	 * 条件
	 */
	private String condition;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 是否为菜单
	 */
	private Integer ismenu;
	/**
	 * 菜单类型
	 */
	private MenuType menutype;
	/**
	 * 扩展属性
	 */
	private String extend;
	/**
	 * 拼音首字母
	 */
	private String py;
	/**
	 * 拼音
	 */
	private String pinyin;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Long createtime;
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
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
