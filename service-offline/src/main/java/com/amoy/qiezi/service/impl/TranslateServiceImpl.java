package com.amoy.qiezi.service.impl;

import com.amoy.qiezi.service.TranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TranslateServiceImpl implements TranslateService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String translate(String content, String target) {
        return translate(content, target, "en");
    }

    @Override
    public String translate(String content, String target, String source) {
        return null;
    }
}
