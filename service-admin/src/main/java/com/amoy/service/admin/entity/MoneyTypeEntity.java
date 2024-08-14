package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-14 12:07:59
 */
@Data
@TableName("fa_money_type")
public class MoneyTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 显示名称
	 */
	private String showName;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 商户号
	 */
	private String merNo;
	/**
	 * 商户key
	 */
	private String merKey;
	/**
	 * 最小充值金额
	 */
	private String minRechargeMoney;
	/**
	 * 排序
	 */
	private String sort;
	/**
	 * 最小提现金额
	 */
	private BigDecimal minExtractMoney;
	/**
	 * 最大提现金额
	 */
	private BigDecimal maxExtractMoney;
	/**
	 * 充值是否开启
	 */
	private String rechargeIsShow;
	/**
	 * 提现是否开启
	 */
	private String extractIsShow;
	/**
	 * 汇率
	 */
	private BigDecimal exchangeRate;
	/**
	 * 汇率更新时间
	 */
	private Long exchangeUpdateTime;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * 是否启用:0=启用;1=禁用
	 */
	private String status;
	/**
	 * 充值描述
	 */
	private String remark;
	/**
	 * 操作员
	 */
	private Integer operater;
	/**
	 * 创建时间
	 */
	@TableField(value = "createtime", fill = FieldFill.INSERT)
	private Long createtime;
	/**
	 * 修改时间
	 */
	@TableField(value = "updatetime", fill = FieldFill.UPDATE)
	private Long updatetime;
}
