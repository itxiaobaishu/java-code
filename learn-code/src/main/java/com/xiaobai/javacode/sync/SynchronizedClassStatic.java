package com.xiaobai.javacode.sync;

/**
 * @author xiaobai
 * @description:
 * @date 2020/7/13 12:09 下午
 */
public class SynchronizedClassStatic implements Runnable {

    static SynchronizedClassStatic synchronizedClassStatic1 = new SynchronizedClassStatic();
    static SynchronizedClassStatic synchronizedClassStatic2 = new SynchronizedClassStatic();

    public static void main(String[] args) {
        Thread t1 = new Thread(synchronizedClassStatic1);
        Thread t2 = new Thread(synchronizedClassStatic2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished2");
    }


    public static synchronized void method() {
        System.out.println("我是类锁的第一种形式：static方法锁：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束。");
    }

    @Override
    public void run() {

        method();

    }
}
