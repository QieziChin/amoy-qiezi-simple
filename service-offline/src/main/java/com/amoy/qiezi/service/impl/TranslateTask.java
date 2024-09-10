package com.amoy.qiezi.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.amoy.common.utils.Digest;
import com.amoy.common.utils.Result;
import com.amoy.qiezi.dao.VideoDao;
import com.amoy.qiezi.dao.VideoTranslationsDao;
import com.amoy.qiezi.entity.*;
import com.amoy.qiezi.service.TranslateService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j2
@RefreshScope
@Service("translateTask")
public class TranslateTask  extends RobotServiceImpl{

    @Value("${qiezi.translate.drive}")
    String driveName;

    @Value("${qiezi.translate.language}")
    String language;

    @Resource
    VideoTranslationsDao translationsDao;

    @Resource
    @Qualifier("deepLService")
    TranslateService deepLService;

    @Resource
    @Qualifier("cloudflare")
    TranslateService cloudflare;

    @Resource
    VideoDao videoDao;

    /**
     * 根据驱动返回对应语言包代码
     * @return
     */
    private Map<String, Integer> getLang(String payload){
        //zh-CN,zh-TW,vi-VH,pt-BR,hi-IN,ko-KR
        Map<String, Integer> lang = new HashMap<>();
        String[] langList = payload.split(",");
        for(String item: langList){
            String hashKey = Digest.MD5.getHash(driveName + item);
            if (redisUtils.hasKey("language", hashKey)){
                Language entity = (Language)redisUtils.hGet("language", hashKey);
                lang.put(entity.getTarget(), entity.getCode());
            }
        }
        return lang;
    }

    public void threads(JSONObject video, Map<String, Integer> entrys) throws Exception{
        Collection<VideoTranslationsEntity> entities = new ArrayList<>();
        try {
            for (String lang: entrys.keySet()){
                if (stop) { throw new RuntimeException();}
                Integer code = entrys.get(lang);
                VideoTranslationsEntity entity = new VideoTranslationsEntity();
                entity.setVideoId(video.getIntValue("videoId"));
                entity.setLangId(code);
                if (driveName.equals("deepl")) {
                    entity.setTitle(deepLService.translate(video.getString("title"), lang));
                    entity.setDescription(deepLService.translate(video.getString("description"), lang));
                } else if (driveName.equals("cloudflare")) {
                    entity.setTitle(cloudflare.translate(video.getString("title"), lang));
                    entity.setDescription(cloudflare.translate(video.getString("description"), lang));
                }
                entity.setMetaTitle("");
                entity.setMetaDesc("");
                entity.setMetaKeys("");
                entity.setCustom1("");
                entity.setCustom2("");
                entity.setCustom3("");
                entities.add(entity);
                log.info("视频:{} - {}已翻译", video.getString("videoId"), lang);
            }
            translationsDao.insert(entities);
            log.info("视频:{} - 翻译入库", video.getString("videoId"));
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    /**
     * 执行翻译任务
     */
    @Override
    public void exec() {
        //获取当前任务集合
        Set<Object> ids = redisUtils.hKeys("translate");
        for (Object id: ids){
            try {
                //获取一个任务
                if (stop) {break;}
                JSONObject task = (JSONObject)redisUtils.hGet("translate", String.valueOf(id));
                threads(task, getLang(language));
                redisUtils.delete("translate", String.valueOf(id));
            } catch (Exception e){
                //继续处理下一条
                continue;
            }
        }
    }
    /**
     * 当前页的添加翻译任务
     * @param page
     */
    private void getScheduleData(Page page, Integer thread){
        videoDao.getPage(page).forEach((video)->{
            JSONObject translate = new JSONObject();
            translate.put("videoId", video.getVideoId());
            translate.put("title", video.getTitle());
            translate.put("description", video.getDescription());
            redisUtils.hSet("translatex"+String.valueOf(thread), String.valueOf(video.getVideoId()), translate);
        });
    }

    @Override
    public Result test(Integer thread){
        if (redisUtils.hasKey("schedule", "translatex0")){
            Page page = (Page)redisUtils.hGet("schedule", "translatex0");
            return Result.error(page.toString());
        } else {
            int total = videoDao.selectCount(new QueryWrapper<VideoEntity>()).intValue();
            int average = total / thread;
            int rem = total - average * thread;
            for (int i = 0; i< thread; i++){
                Page page = new Page();
                page.setOffset(average * i);
                page.setTotal(i == thread ? average : average + rem);
                if (page.next()){
                    getScheduleData(page, i);
                }
                redisUtils.hSet("schedule", "translatex"+String.valueOf(i), page);
            }

            return Result.success().put("schedule", redisUtils.hGet("schedule", "translatex0"));
        }
    }

    @Override
    public void extend(String payload, Integer thread) {
        String hashKey = "translatex" + String.valueOf(thread);
        if (redisUtils.hasKey("schedule", hashKey)){
            Page page = (Page)redisUtils.hGet("schedule", hashKey);
            //获取当前任务集合
            Set<Object> ids = redisUtils.hKeys(hashKey);
            for (Object id: ids){
                if (stop) { break;}
                //获取一个任务
                JSONObject task = (JSONObject)redisUtils.hGet(hashKey, String.valueOf(id));
                try {
                    threads(task, getLang(payload));
                    log.info("扩展翻译视频:{}已完成", id);
                    redisUtils.delete(hashKey, String.valueOf(id));
                } catch (Exception e){
                    redisUtils.delete(hashKey, String.valueOf(id));
                    redisUtils.hSet("translatex99", String.valueOf(id), task);
                    log.info("扩展翻译视频: {} -- 失败{}",id, e.getMessage());
                }
            }
            //当前页翻译完布置下一页任务
            if (page.next()){
                getScheduleData(page, thread);
            }
            redisUtils.hSet("schedule", hashKey, page);
        }
    }
}
