package com.xiaobai.springbootkafka.controller;

import com.xiaobai.springbootkafka.entity.Book;
import com.xiaobai.springbootkafka.service.BookProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2020/11/10 3:53 下午
 */

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Value("${kafka.topic.my-topic1}")
    String myTopic1;

    @Value("${kafka.topic.my-topic2}")
    String myTopic2;

    private AtomicLong atomicLong = new AtomicLong();

    private final BookProducerService bookProducerService;

    public BookController(BookProducerService bookProducerService) {
        this.bookProducerService = bookProducerService;
    }

    @GetMapping
    public void sendMessageToKafkaTopic(@RequestParam("name") String name) {
        bookProducerService.sendMessage(myTopic1, new Book(atomicLong.addAndGet(1), name));
        bookProducerService.sendMessage(myTopic2, new Book(atomicLong.addAndGet(1), name));

    }
}
