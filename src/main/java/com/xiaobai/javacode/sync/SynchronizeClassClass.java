package com.xiaobai.javacode.sync;

/**
 * @author xiaobai
 * @description:
 * @date 2020/7/13 12:08 下午
 */
public class SynchronizeClassClass implements Runnable {

    static SynchronizeClassClass synchronizeClassClass1 = new SynchronizeClassClass();
    static SynchronizeClassClass synchronizeClassClass2 = new SynchronizeClassClass();

    @Override
    public void run() {
        method();
    }

    public void method() {
        synchronized (SynchronizeClassClass.class) {
            System.out.println("我是类锁的第二种形式，synchronize（*.class）我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束。");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(synchronizeClassClass1);
        Thread t2 = new Thread(synchronizeClassClass2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished3");
    }
}

