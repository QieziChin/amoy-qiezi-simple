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
 * VIP 配置
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-13 12:21:35
 */
@Data
@TableName("fa_sys_conf_vip")
public class SysConfVipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 会员等级
	 */
	private String level;
	/**
	 * 会员名称
	 */
	private String name;
	/**
	 * 等级图片
	 */
	private String image;
	/**
	 * 收益率
	 */
	private String income;
	/**
	 * 量化次数
	 */
	private Integer taskNum;
	/**
	 * 解锁金额
	 */
	private BigDecimal lockAmount;
	/**
	 * 量化天数
	 */
	private Integer levelValidTime;
	/**
	 * 平台服务费
	 */
	private Integer serviceProportion;
	/**
	 * 预计日收益
	 */
	private String userIncome;
	/**
	 * 回本天数
	 */
	private String paybackCycle;
	/**
	 * 充值返利
	 */
	private String rechargeRebate;
	/**
	 * 量化返利
	 */
	private String taskRebate;
	/**
	 * 复充收益率/封顶
	 */
	private String againChargePercent;
	/**
	 * 显示:1=显示,0=关闭
	 */
	private String isShow;
	/**
	 * 是否可解锁:1=开启,0=锁定
	 */
	private String isUnlock;
	/**
	 * 最小trx提现金额
	 */
	private BigDecimal withdrawTrxMinMoney;
	/**
	 * 最小usdt提现金额
	 */
	private BigDecimal withdrawUsdtMinMoney;
	/**
	 * 提现日期
	 */
	private String extractWeek;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 操作员
	 */
	private Integer operater;
	/**
	 * 删除标识
	 */
	private String isDel;
	/**
	 * 添加时间
	 */
	private Long createTime;
	/**
	 * 修改时间
	 */
	private Long updateTime;
}
