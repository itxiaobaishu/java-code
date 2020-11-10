package com.xiaobai.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/**
 * @author xiaobai
 * @description: kafka配置类
 * @date 2020/11/10 2:10 下午
 */
@Configuration
public class KafkaConfig {

    @Value("${kafka.topic.my-topic1}")
    String myTopic1;
    @Value("${kafka.topic.my-topic2}")
    String myTopic2;

    /**
     * json消息转换器
     *
     * @return
     */
    @Bean
    public RecordMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

    /**
     * 通过注入一个NewTopic类型的Bean来创建topic，如果topic已存在，则会忽略
     *
     * @return
     */
    @Bean
    public NewTopic myTopic1() {
        return new NewTopic(myTopic1, 2, (short) 1);
    }

    @Bean
    public NewTopic myTopic2() {
        return new NewTopic(myTopic2, 1, (short) 1);

    }
}
