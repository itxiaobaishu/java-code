package com.xiaobai.javacode.controller;

import com.xiaobai.javacode.cache.CachePenetrate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaobai
 * @description: 缓存穿透测试控制器
 * @date 2020/1/15 4:45 下午
 */

@RestController
@RequestMapping("/cache")
public class CachePenetrateTestController {

    @Autowired
    private CachePenetrate cachePenetrate;

    @GetMapping("/penetrate")
    public String cachePenetrateTest() {

        //多线程测试一下缓存穿透问题
        //该线程调用底层查询所有学生的方法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //有缓存穿透问题
                cachePenetrate.getAllStudent1();
                //已解决缓存穿透问题
//                cachePenetrate.getAllStudent2();
            }
        };

        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }
        return "";
    }
}
