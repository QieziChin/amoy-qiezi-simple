package com.amoy.qiezi.service;

import com.amoy.common.utils.Result;

public interface RobotService {

    void stop();

    void exec();
    void exec(Integer offset);

    void extend(String payload);

    void extend(String payload, Integer thread);

    Result test(Integer thread);
}
