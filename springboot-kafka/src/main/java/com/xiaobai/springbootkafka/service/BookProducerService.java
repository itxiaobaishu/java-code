package com.xiaobai.springbootkafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author xiaobai
 * @description: 发送消息的生产者
 * @date 2020/11/10 2:40 下午
 */

@Service
@Slf4j
public class BookProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public BookProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object obj) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, obj);
        future.addCallback(result -> log.info("生产者成功发送消息到topic:{} partition:{}的消息", result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                ex -> log.error("生产者发送消失败，原因：{}", ex.getMessage()));
    }
}
