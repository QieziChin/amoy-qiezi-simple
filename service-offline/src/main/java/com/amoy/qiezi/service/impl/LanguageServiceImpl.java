package com.amoy.qiezi.service.impl;

import com.amoy.common.utils.Digest;
import com.amoy.common.utils.RedisUtils;
import com.amoy.qiezi.entity.Language;
import com.amoy.qiezi.service.LanguageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Resource
    protected RedisUtils redisUtils;

    @Override
    public void add(Language lang) {
        String hashKey = Digest.MD5.getHash(lang.getDrive() + lang.getLanguage());
        redisUtils.hSet("language", hashKey, lang);
    }
}
