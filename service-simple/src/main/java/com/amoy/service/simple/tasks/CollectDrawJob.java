package com.amoy.service.simple.tasks;

import com.amoy.service.simple.mapper.DrawMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CollectDrawJob {

    @Autowired
    private DrawMapper drawMapper;

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * @Scheduled(fixedRate = 1000 * 1)每间隔周期开始
     * @Scheduled(fixedDelay = 1000 * 1)执行完之后再间隔周期开始
     * @Scheduled(cron = "0/10 * * * * ?")表达式
     * @Scheduled(cron = "{秒数} {分钟} {小时} {日期} {月份} {星期}")
     *
     * “15-30/5 * * * * ?” 每分钟的15秒到30秒之间开始触发，每隔5秒触发一次
     * @throws InterruptedException
     */
    @Scheduled(cron = "0 0 21-23/1 * * ?")
    public void task1() throws InterruptedException {
        //越南彩票统计预测采集
        System.out.println(simple.format(new Date())+ "-越南彩票统计预测采集-task1");
//        List<Draw> list = drawMapper.task1();
//        CollectUtils.bietnamDraw(drawMapper, list);
    }
//    @Scheduled(cron = "0/30 * * * * ?")
//    @Scheduled(cron = "0 */30 * * * ?")
    @Scheduled(cron = "0 0 8-21/2 * * ?")//每2小时执行一次
    public void task2() throws InterruptedException {
        //越南彩票开奖结果采集
        System.out.println(simple.format(new Date())+ "-越南彩票开奖结果采集-task2");
//        List<Draw> list = drawMapper.list();
//        CollectUtils.bietnamDraw(drawMapper, list);
    }

    @Scheduled(cron = "0 0 8-21/1 * * ?")
    public void task0() throws InterruptedException {
        System.out.println(simple.format(new Date())+ "-测试线程-task0");
    }


}
