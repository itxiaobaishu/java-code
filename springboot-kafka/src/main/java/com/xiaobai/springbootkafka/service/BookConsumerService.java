package com.xiaobai.springbootkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaobai.springbootkafka.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author xiaobai
 * @description: 消费消息的消费者
 * @date 2020/11/10 2:58 下午
 */

@Service
@Slf4j
public class BookConsumerService {


    @Value("${kafka.topic.my-topic1}")
    private String myTopic1;

    @Value("${kafka.topic.my-topic2}")
    private String myTopic2;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = {"${kafka.topic.my-topic1}"}, groupId = "group1")
    public void  consumerMessage(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            Book book = objectMapper.readValue(bookConsumerRecord.value(), Book.class);
            log.info("消费者消费topic:{} partition:{}的消息 -> {}", bookConsumerRecord.topic(), bookConsumerRecord.partition(), book.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = {"${kafka.topic.my-topic2}"}, groupId = "group2")
    public void consumerMessage2(Book book) {
        log.info("消费者消费{}的消息 -> {}", myTopic2, book.toString());
    }
}
