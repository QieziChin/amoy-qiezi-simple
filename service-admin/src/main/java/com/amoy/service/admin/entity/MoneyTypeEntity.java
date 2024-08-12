package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
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
	private Enum type;
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
	private String minExtractMoney;
	/**
	 * 最大提现金额
	 */
	private String maxExtractMoney;
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
	private String exchangeRate;
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
	private Enum status;
	/**
	 * 创建时间
	 */
	private Long createtime;

}
