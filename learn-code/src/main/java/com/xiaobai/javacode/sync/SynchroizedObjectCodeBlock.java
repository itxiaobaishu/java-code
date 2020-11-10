package com.xiaobai.javacode.sync;

/**
 * @author xiaobai
 * @description:
 * @date 2020/7/13 12:06 下午
 */
public class SynchroizedObjectCodeBlock implements Runnable {

    static SynchroizedObjectCodeBlock synchroizedObjectCodeBlock = new SynchroizedObjectCodeBlock();

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我是lock1，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束。");
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(synchroizedObjectCodeBlock);
        Thread t2 = new Thread(synchroizedObjectCodeBlock);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
