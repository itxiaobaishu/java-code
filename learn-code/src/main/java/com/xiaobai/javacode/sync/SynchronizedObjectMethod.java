package com.xiaobai.javacode.sync;

/**
 * @author xiaobai
 * @description:
 * @date 2020/7/13 12:11 下午
 */
public class SynchronizedObjectMethod implements Runnable {

    static SynchronizedObjectMethod synchronizedObjectMethod = new SynchronizedObjectMethod();

    public static void main(String[] args) {
        Thread t1 = new Thread(synchronizedObjectMethod);
        Thread t2 = new Thread(synchronizedObjectMethod);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished1");
    }

    @Override
    public void run() {
        method();

    }

    public synchronized void method() {
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束。");
    }
}
