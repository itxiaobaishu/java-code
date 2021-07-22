package com.xiaobai.springbootevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author xiaobai
 * @description:
 * @date 2021/7/22 11:36 上午
 */
@SpringBootApplication
//事件异步处理实现第一种方式：使用@EnableAsync
//@EnableAsync
public class SpringBootEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEventApplication.class, args);
    }
}
