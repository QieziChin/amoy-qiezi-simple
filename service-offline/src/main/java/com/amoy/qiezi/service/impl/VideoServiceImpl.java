package com.amoy.qiezi.service.impl;

import com.amoy.common.utils.Result;
import com.amoy.qiezi.dao.VideoDao;
import com.amoy.qiezi.entity.VideoEntity;
import com.amoy.qiezi.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoDao, VideoEntity> implements VideoService {

    @Override
    public Result cervix() {
        return null;
    }

}