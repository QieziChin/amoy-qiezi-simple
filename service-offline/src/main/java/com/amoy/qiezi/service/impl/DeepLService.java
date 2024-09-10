package com.amoy.qiezi.service.impl;

import com.deepl.api.Translator;
import com.deepl.api.TranslatorOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("deepLService")
public class DeepLService extends TranslateServiceImpl {

    private Translator translator;

    @Value("${deepl.security.key}")
    private String authKey;

    @Override
    public String translate(String content, String target, String source) {
        if (translator == null) translator = new Translator(authKey);
        try {
            return translator.translateText(content, source, target).getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
