package com.amoy.qiezi.config;


import com.amoy.qiezi.service.RobotService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class GracefulShutdownListener implements ApplicationListener<ContextClosedEvent> {


    @Resource
    @Qualifier("translateTask")
    RobotService translate;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        translate.stop();
    }
}
