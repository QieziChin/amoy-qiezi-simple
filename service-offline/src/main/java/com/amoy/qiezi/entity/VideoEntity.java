package com.amoy.qiezi.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-09-05 15:56:50
 */
@Data
@TableName("video")
public class VideoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "video_id", type = IdType.AUTO)
	private Integer videoId;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private Integer serverId;
	/**
	 * 
	 */
	private Integer channelId;
	/**
	 * 
	 */
	private Integer dvdId;
	/**
	 * 
	 */
	private Integer orientation;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String slug;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private Float rating;
	/**
	 * 
	 */
	private Integer likes;
	/**
	 * 
	 */
	private Integer ratedBy;
	/**
	 * 
	 */
	private Float percent;
	/**
	 * 
	 */
	private Float percentToday;
	/**
	 * 
	 */
	private Float percentWeek;
	/**
	 * 
	 */
	private Float percentMonth;
	/**
	 * 
	 */
	private Float percentYear;
	/**
	 * 
	 */
	private Float duration;
	/**
	 * 
	 */
	private Integer thumb;


	@TableField(exist = false)
	private String tags;

	@TableField(exist = false)
	private String category;
	/**
	 * 
	 */
	private Integer thumbs;
	/**
	 * 
	 */
	private Integer thumbTime;
	/**
	 * 
	 */
	private String thumbUrl;
	/**
	 * 
	 */
	private String embedCode;
	/**
	 * 
	 */
	private Integer allowEmbed;
	/**
	 * 
	 */
	private Integer allowRating;
	/**
	 * 
	 */
	private Integer allowComment;
	/**
	 * 
	 */
	private Integer allowDownload;
	/**
	 * 
	 */
	private Integer totalViews;
	/**
	 * 
	 */
	private Integer todayViews;
	/**
	 * 
	 */
	private Integer weekViews;
	/**
	 * 
	 */
	private Integer monthViews;
	/**
	 * 
	 */
	private Integer yearViews;
	/**
	 * 
	 */
	private Integer totalComments;
	/**
	 * 
	 */
	private Integer totalDownloads;
	/**
	 * 
	 */
	private Integer totalFavorites;
	/**
	 * 
	 */
	private Integer totalEmbeds;
	/**
	 * 
	 */
	private Integer totalFiles;
	/**
	 * 
	 */
	private Float ctr;
	/**
	 * 
	 */
	private Float ctrToday;
	/**
	 * 
	 */
	private Integer files;
	/**
	 * 
	 */
	private Integer trailer;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Integer hd;
	/**
	 * 
	 */
	private Integer mobile;
	/**
	 * 
	 */
	private Integer hotlinked;
	/**
	 * 
	 */
	private Integer hls;
	/**
	 * 
	 */
	private Integer simple;
	/**
	 * 
	 */
	private Integer premium;
	/**
	 * 
	 */
	private Float price;
	/**
	 * 
	 */
	private Integer s3;
	/**
	 * 
	 */
	private String metaTitle;
	/**
	 * 
	 */
	private String metaDesc;
	/**
	 * 
	 */
	private String metaKeys;
	/**
	 * 
	 */
	private String custom1;
	/**
	 * 
	 */
	private String custom2;
	/**
	 * 
	 */
	private String custom3;
	/**
	 * 
	 */
	private Integer addTime;
	/**
	 * 
	 */
	private Integer viewTime;
	/**
	 * 
	 */
	private Integer convTime;
	/**
	 * 
	 */
	private Integer editTime;
	/**
	 * 
	 */
	private Integer editUserId;
	/**
	 * 
	 */
	private Integer featured;
	/**
	 * 
	 */
	private Integer featuredTime;
	/**
	 * 
	 */
	private Integer flagged;
	/**
	 * 
	 */
	private Integer flagTime;
	/**
	 * 
	 */
	private Integer errno;
	/**
	 * 
	 */
	private Integer locked;
	/**
	 * 
	 */
	private Integer status;
}
