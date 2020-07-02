package com.xiaobai.javacode.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author xiaobai
 * @description: spring中三种初始化方法的执行顺序
 * @date 2020/7/2 9:51 上午
 */
@Slf4j
@Service
public class InitService implements InitializingBean {

    /**
     * 重写InitializingBean接口的afterPropertiesSet()方法初始化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("----------InitializingBean afterPropertiesSet() init --------");
    }

    /**
     * 使用@PostConstruct注解初始化
     */
    @PostConstruct
    public void init() {
        log.info("----------PostConstruct init --------");
    }

    /**
     * 使用init-method方法初始化
     */
    @Bean
    public void initMethod() {
        log.info("----------init-method --------");
    }

    public void otherMethod() {
        log.info("----------otherMethod --------");
    }
}
