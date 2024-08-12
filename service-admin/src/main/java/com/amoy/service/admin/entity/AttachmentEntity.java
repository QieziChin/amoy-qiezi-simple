package com.amoy.service.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 附件表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Data
@TableName("fa_attachment")
public class AttachmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 管理员ID
	 */
	private Integer adminId;
	/**
	 * 会员ID
	 */
	private Integer userId;
	/**
	 * 物理路径
	 */
	private String url;
	/**
	 * 宽度
	 */
	private String imagewidth;
	/**
	 * 高度
	 */
	private String imageheight;
	/**
	 * 图片类型
	 */
	private String imagetype;
	/**
	 * 图片帧数
	 */
	private Integer imageframes;
	/**
	 * 文件名称
	 */
	private String filename;
	/**
	 * 文件大小
	 */
	private Integer filesize;
	/**
	 * mime类型
	 */
	private String mimetype;
	/**
	 * 透传数据
	 */
	private String extparam;
	/**
	 * 创建日期
	 */
	private Long createtime;
	/**
	 * 更新时间
	 */
	private Long updatetime;
	/**
	 * 上传时间
	 */
	private Long uploadtime;
	/**
	 * 存储位置
	 */
	private String storage;
	/**
	 * 文件 sha1编码
	 */
	private String sha1;

}
