package com.amoy.service.admin.interceptor;


import com.amoy.common.utils.JwtUtil;
import com.amoy.common.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //获取token
        String token = request.getHeader("Authorization");
        //验证token
        try {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

            if (operations.get(token) == null){
                throw new RuntimeException("登录已过期，请重新登陆");
            }

            Map<String, Object> claims = JwtUtil.parseToken(token);
            //验证的用户信息存放到ThreadLocal中
            ThreadLocalUtil.set(claims);
            return true;
        } catch(Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据 防止内存泄漏
        ThreadLocalUtil.remove();
    }
}

