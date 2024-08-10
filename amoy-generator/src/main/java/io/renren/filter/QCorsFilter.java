package io.renren.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//取消 @Configuration 注释生效
@Configuration
public class QCorsFilter {

    //取消 @Bean 注释生效
    @Bean
    public CorsFilter corsFilter(){
        //创建 CORS 配置对象
        CorsConfiguration config = new CorsConfiguration();

        //支持域
        config.addAllowedOrigin("*");

        //支持请求头
        config.addAllowedHeader("*");
        //支持证书
        config.setAllowCredentials(true);

        //支持方法
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(corsConfigurationSource);
    }
}
