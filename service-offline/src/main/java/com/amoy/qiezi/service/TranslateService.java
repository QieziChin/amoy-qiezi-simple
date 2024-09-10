package com.amoy.qiezi.service;

public interface TranslateService {

    String translate(String content, String target);

    String translate(String content, String target, String source);
}
