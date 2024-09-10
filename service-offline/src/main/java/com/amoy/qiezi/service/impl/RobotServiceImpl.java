package com.amoy.qiezi.service.impl;

import com.amoy.common.utils.RedisUtils;
import com.amoy.common.utils.Result;
import com.amoy.qiezi.service.RobotService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RobotServiceImpl implements RobotService {

    @Resource
    protected RedisUtils redisUtils;

    /**
     * 线程关闭标识
     */
    protected Boolean stop = false;;

    private Integer thread = 0;

    @Override
    public void stop() {
        this.stop = true;
    }

    @Override
    public void exec() {
        exec(0);
    }

    @Override
    public void exec(Integer offset) {

    }

    @Override
    public void extend(String payload) {
        extend(payload, thread);
    }

    @Override
    public void extend(String payload, Integer thread) {

    }

    @Override
    public Result test(Integer thread){
        return null;
    }
}
