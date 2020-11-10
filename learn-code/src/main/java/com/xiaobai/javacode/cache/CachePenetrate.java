package com.xiaobai.javacode.cache;

import com.xiaobai.javacode.entity.Student;
import com.xiaobai.javacode.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaobai
 * @description: 模拟缓存场景
 * @date 2020/1/15 10:43 上午
 */
@Service
public class CachePenetrate {

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 有缓存穿透问题
     *
     * @return
     */
    public List<Student> getAllStudent1() {
        //高并发条件下，此处有点问题：缓存穿透
        //查询缓存
        Object obj = redisUtil.get("allStudent");
        if (null == obj) {
            System.out.println("查询数据库.......");
            //缓存为空，查询数据库，存的缓存中
            redisUtil.set("allStudent", "students");
        } else {
            System.out.println("查询的缓存。。。。。。");
        }
        return null;
    }

    /**
     * 双重检测锁 解决缓存穿透问题
     *
     * @return
     */
    public List<Student> getAllStudent2() {
        //高并发条件下，此处有点问题：缓存穿透
        //查询缓存
        Object obj = redisUtil.get("allStudent");
        //双重检测锁
        if (null == obj) {
            synchronized (this) {
                //从redis获取一下
                obj = redisUtil.get("allStudent");
                if (null == obj) {
                    System.out.println("查询数据库.......");
                    //缓存为空，查询数据库，存的缓存中
                    redisUtil.set("allStudent", "students");
                } else {
                    System.out.println("查询的缓存。。。。。。");
                }
            }
        } else {
            System.out.println("查询的缓存。。。。。。");
        }
        return null;
    }
}
