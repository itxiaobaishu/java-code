package com.xiaobai.javacode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author xiaobai
 * @description: 线程异步执行service
 * @date 2020/5/20 4:40 下午
 */
@Service
@Slf4j
public class ThreadTaskService {

    /**
     * 发送短信1
     *
     * @throws InterruptedException
     */
//    @PostConstruct//加上该注解项目启动时就执行一次该方法
    @Async("taskExecutor")
    public void sendMessage1() {
        log.info("发送短信方法------1-----执行开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        log.info("发送短信方法------1-----执行结束");
    }

    /**
     * 发送短信2
     *
     * @throws InterruptedException
     */
//    @PostConstruct//加上该注解项目启动时就执行一次该方法
    @Async("taskExecutor")
    public void sendMessage2() {
        log.info("发送短信方法------2-----执行开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        log.info("发送短信方法------2-----执行结束");
    }


    /**
     * 发送短信3
     *
     * @throws InterruptedException
     */
    public void sendMessage3() {
        log.info("发送短信方法------3-----执行开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        log.info("发送短信方法------3-----执行结束");
    }

    /**
     * 发送短信4
     *
     * @throws InterruptedException
     */
    public void sendMessage4() {
        log.info("发送短信方法------4-----执行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        }
        log.info("发送短信方法------4-----执行结束");
    }
}
