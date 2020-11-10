package com.xiaobai.javacode.systimestamp;

/**
 * @author xiaobai
 * @description: SystemClock测试
 * @date 2020/7/1 10:51 上午
 */
public class SystemClockTest {

    public static void main(String[] args) {
        int times = Integer.MAX_VALUE;
        long start = System.currentTimeMillis();
        for (long i = 0; i < times; i++) {
            SystemClock.now();
        }
        long end = System.currentTimeMillis();
        System.out.println("SystemClock Time:" + (end - start) + "毫秒");
        long start2 = System.currentTimeMillis();
        for (long i = 0; i < times; i++) {
            System.currentTimeMillis();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("SystemCurrentTimeMillis Time:" + (end2 - start2) + "毫秒");
    }

    //输出结果
    //SystemClock Time:1251毫秒
    //SystemCurrentTimeMillis Time:54433毫秒
}
