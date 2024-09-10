package com.amoy.qiezi.task;


import com.amoy.qiezi.service.RobotService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RobotTask {
    @Resource
    @Qualifier("downloadTask")
    RobotService download;

    @Resource
    @Qualifier("translateTask")
    RobotService translate;

    @Value("${qiezi.translate.extend}")
    private String payload;


    @Scheduled(cron = "0 0 0/1 * * ?")
    public void downPlayCover() {
        download.exec();
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void translate() {
        translate.exec();
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void translate0() {
        translate.extend(payload);
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void translate1() {
        translate.extend(payload);
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void translate2() {
        translate.extend(payload);
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void translate3() {
        translate.extend(payload);
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void translate4() {
        translate.extend(payload);
    }


    @Scheduled(cron = "0 0 0/1 * * ?")
    public void translate99() {
        translate.extend(payload, 99);
    }
}
