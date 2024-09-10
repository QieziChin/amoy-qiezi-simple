package com.amoy.qiezi.config;

import com.amoy.common.utils.Digest;
import com.amoy.common.utils.RedisUtils;
import com.amoy.qiezi.dao.CategoryDao;
import com.amoy.qiezi.dao.TagsDao;
import com.amoy.qiezi.entity.CategoryEntity;
import com.amoy.qiezi.entity.TagsEntity;
import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocalInitialize implements ApplicationRunner {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    TagsDao tagsDao;

    @Resource
    CategoryDao categoriesDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<TagsEntity> tags = tagsDao.listAll();

        for (TagsEntity tag: tags){
            String hashKey = Digest.MD5.getHash(tag.getTag().toLowerCase());
            redisUtils.hSet("tags", hashKey, tag);
        }

        List<CategoryEntity> cates = categoriesDao.listAll();

        for (CategoryEntity tag: cates){
            String hashKey = Digest.MD5.getHash(tag.getName().toLowerCase());
            redisUtils.hSet("category", hashKey, tag);
        }
    }
}
