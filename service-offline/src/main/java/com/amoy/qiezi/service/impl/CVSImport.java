package com.amoy.qiezi.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.amoy.common.utils.*;
import com.amoy.qiezi.dao.*;
import com.amoy.qiezi.entity.*;
import com.amoy.qiezi.service.CategoryService;
import com.amoy.qiezi.service.FulltextService;
import com.amoy.qiezi.service.TranslateService;
import com.amoy.qiezi.service.VideoService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

@Service("vulva")
public class CVSImport extends VideoServiceImpl{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${qiezi.upload.path}")
    String filepath;

    @Value("${qiezi.ignore.tag}")
    Boolean tagIgnore;

    @Value("${qiezi.image.local}")
    Boolean isImageLocal;

    @Value("${qiezi.ignore.category}")
    Boolean categoryIgnore;

    @Resource
    private RedisUtils redisUtils;

    private Random random = new Random();

    @Resource
    @Qualifier("videoService")
    VideoService videoService;

    @Resource
    TagsDao tagsDao;
    @Resource
    VideoTagsDao videoTagsDao;

    @Resource
    CategoryDao categoryDao;

    @Resource
    VideoLoadsDao videoLoadsDao;

    @Resource
    FulltextService fulltextService;

    @Resource
    CategoryService categoryService;

    /**
     * 同步数据
     */
    private void synchronize(){
        List<Object> categorys = redisUtils.hVals("category");

        for (Object object: categorys){
            CategoryEntity category = (CategoryEntity)object;
            categoryDao.updateStatistics(category);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void postRow(VideoEntity video) throws Exception{
        videoService.save(video);

        if (isImageLocal) redisUtils.hSet("download", String.valueOf(video.getVideoId()), video.getThumbUrl());
        String[] tags = video.getTags().split(",");
        for (String tag: tags){
            String hashKey = Digest.MD5.getHash(tag.toLowerCase());
            //视频标签
            VideoTagsEntity videoTags = new VideoTagsEntity();
            videoTags.setVideoId(video.getVideoId());

            //判断标签是否存在
            if (redisUtils.hasKey("tags", hashKey)){
                TagsEntity tagsEntity = (TagsEntity)redisUtils.hGet("tags", hashKey);
                videoTags.setTagId(tagsEntity.getTagId());
            } else {
                TagsEntity tagsEntity = new TagsEntity();
                tagsEntity.setTag(tag);
                tagsEntity.setAutoTerms(tag);
                tagsEntity.setVideos(1);
                //维护标签
                tagsDao.insert(tagsEntity);
                redisUtils.hSet("tags", hashKey, tagsEntity);
                videoTags.setTagId(tagsEntity.getTagId());
            }

            //插入标签
            videoTagsDao.insert(videoTags);
        }

        //添加翻译视频任务
        JSONObject translate = new JSONObject();
        translate.put("videoId", video.getVideoId());
        translate.put("title", video.getTitle());
        translate.put("description", video.getDescription());
        redisUtils.hSet("translate", String.valueOf(video.getVideoId()), translate);

        String[] categorys = video.getCategory().split(",");
        for (String category: categorys){
            if (StringUtils.isEmpty(category)) continue;
            String hashKey = Digest.MD5.getHash(category.toLowerCase());
            if (redisUtils.hasKey("category", hashKey)){
                CategoryEntity cate = (CategoryEntity)redisUtils.hGet("category", hashKey);
                cate.setTotalVideos(cate.getTotalVideos() + 1);
                cate.setTodayVideos(cate.getTodayVideos() + 1);
                VideoCategoryEntity item = new VideoCategoryEntity();
                item.setVideoId(video.getVideoId());
                item.setCatId(cate.getCatId());
                categoryService.save(item);
                redisUtils.hSet("category", hashKey, cate);
            }
        }

        FulltextEntity fulltext = new FulltextEntity();
        fulltext.setVideoId(video.getVideoId());
        fulltext.setOrientation(1);
        fulltext.setTitle(video.getTitle());
        fulltext.setStatus(6);

        fulltextService.save(fulltext);

        VideoLoadsEntity loads = new VideoLoadsEntity();
        loads.setVideoId(video.getVideoId());
        loads.setTodayLoads(0);
        loads.setTotalLoads(0L);
        videoLoadsDao.insert(loads);
    }



    private float rate(float min, float max){
        return min + random.nextFloat() * (max - min);
    }

    private int rated(int min, int max){
        return min + random.nextInt(max - min) + 1;
    }

    @Override
    public Result cervix() {
        JSONObject reslut = new JSONObject();
        try {
            Scanner reader = new Scanner(new FileInputStream(filepath));
            int total = 0, error = 0, ignore = 0;
            while (reader.hasNextLine()) {
                total ++;
                String line = reader.nextLine();
                String hashKey = Digest.MD5.getHash(line.toLowerCase());
                log.info("检查数据：key{}", hashKey);
                // 没缓存过 hashKey 写数据库
                if (!redisUtils.hasKey("video", hashKey)){
                    line = line.replaceAll("\t", "|");
                    String[] entity = line.split("\\|");

                    VideoEntity video = new VideoEntity();
                    video.setUserId(2);
                    video.setServerId(1);
                    video.setChannelId(0);
                    video.setDvdId(0);
                    video.setOrientation(1);
                    video.setTitle(entity[3]);
                    video.setSlug(entity[4].replaceAll(",", "-").replaceAll(" ", "-"));
                    video.setDescription(entity[7]);
                    video.setCategory(entity[8]);

                    video.setRatedBy(rated(20, 22));
                    video.setLikes(rated(17, video.getRatedBy()));

                    float rating = Float.valueOf(video.getLikes()) / Float.valueOf(video.getRatedBy()) * 5;
                    rating = BigDecimal.valueOf(rating).setScale(2, RoundingMode.HALF_EVEN).floatValue();
                    video.setRating(rating);

                    float percent = BigDecimal.valueOf(Float.valueOf(video.getLikes()) / Float.valueOf(video.getRatedBy()) * 100).setScale(4, BigDecimal.ROUND_CEILING).floatValue();
                    video.setPercent(percent);

                    video.setPercentToday(percent);
                    video.setPercentWeek(percent);
                    video.setPercentMonth(percent);
                    video.setPercentYear(percent);

                    int views = rated(2000, 10000);
                    video.setTotalViews(views);
                    //标签
                    video.setTags(entity[4]);
                    //getSecond
                    video.setDuration(DateTimeUtils.getSecond(entity[5]));

                    video.setThumb(1);
                    video.setThumbs(0);
                    video.setThumbTime(0);

                    video.setThumbUrl(isImageLocal ? entity[2] : StringUtils.nudityDomain(entity[2]));

                    video.setEmbedCode(entity[6]);

                    video.setCustom1("");
                    video.setCustom2("");
                    video.setCustom3("");
                    video.setAddTime((int)DateTimeUtils.timestamp());
                    video.setViewTime(0);
                    video.setConvTime(0);
                    video.setEditTime(0);

                    video.setEditUserId(0);
                    video.setFeatured(0);
                    video.setFeaturedTime(0);
                    video.setFlagged(0);
                    video.setFlagTime(0);
                    video.setErrno(0);

                    video.setLocked(0);
                    video.setStatus(1);

                    try{
                        postRow(video);
                        redisUtils.hSet("video", hashKey, "");
                        log.info("视频已导入：key{}", video.getVideoId());
                    } catch (Exception e) {
                        log.info("导入错误：{}", line);
                        error++;
                    }
                } else {
                    ignore++;
                    log.info("视频已忽略：key{}", hashKey);
                }
            }
            reslut.put("total:", total);
            reslut.put("error:", error);
            reslut.put("ignore:", ignore);
            reader.close();
            this.synchronize();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return  Result.success(reslut);
    }
}
