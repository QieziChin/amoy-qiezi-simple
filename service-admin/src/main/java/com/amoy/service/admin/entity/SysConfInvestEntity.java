package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 投资配置
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Data
@TableName("fa_sys_conf_invest")
public class SysConfInvestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 产品类型:1=普通投资,2=提现投资
	 */
	private Enum productType;
	/**
	 * 产品图片
	 */
	private String image;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 投资周期
	 */
	private Integer cycle;
	/**
	 * 每日收益率
	 */
	private BigDecimal profit;
	/**
	 * 收益类型:1=按日返息 到期不还本,2=按日返息 到期还本,3=到期本息
	 */
	private Enum profitType;
	/**
	 * 限购数量
	 */
	private Integer buyLimit;
	/**
	 * 剩余数量
	 */
	private Integer overNum;
	/**
	 * 销售状态:1=在售,0=停售
	 */
	private Enum salesStatus;
	/**
	 * 状态:1=开启,0=关闭
	 */
	private Enum status;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 是否删除
	 */
	private Enum isDel;
	/**
	 * 说明内容
	 */
	private String content;
	/**
	 * 添加时间
	 */
	private Long createTime;
	/**
	 * 修改时间
	 */
	private Long updateTime;

}
