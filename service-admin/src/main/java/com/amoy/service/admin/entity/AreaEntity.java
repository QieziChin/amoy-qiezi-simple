package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 地区表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Data
@TableName("fa_area")
public class AreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 父id
	 */
	private Integer pid;
	/**
	 * 简称
	 */
	private String shortname;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 全称
	 */
	private String mergename;
	/**
	 * 层级:1=省,2=市,3=区/县
	 */
	private Integer level;
	/**
	 * 拼音
	 */
	private String pinyin;
	/**
	 * 长途区号
	 */
	private String code;
	/**
	 * 邮编
	 */
	private String zip;
	/**
	 * 首字母
	 */
	private String first;
	/**
	 * 经度
	 */
	private String lng;
	/**
	 * 纬度
	 */
	private String lat;

}
