package com.xiaobai.springbootbeansearcher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootBeanSearcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBeanSearcherApplication.class, args);
        log.info("启动完成");
    }

}
