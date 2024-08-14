package com.amoy.service.admin.config;

import com.amoy.service.admin.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        List<String> patterns = new ArrayList<>();
        patterns.add("/admin/login");
        patterns.add("/upload/**");
        registry.addInterceptor(loginInterceptor).excludePathPatterns(patterns);
    }
}
