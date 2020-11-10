package com.xiaobai.javacode.sync;

/**
 * @author xiaobai
 * @description:
 * @date 2020/7/13 12:03 下午
 */
public class DisappearRequest implements Runnable {

    static DisappearRequest disappearRequest = new DisappearRequest();
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(disappearRequest);
        Thread t2 = new Thread(disappearRequest);
        t1.start();
        t2.start();
        //join方法能保证代码按顺序执行，也就是两个线程执行完在执行打印
        t1.join();
        t2.join();
        System.out.println(i);

    }


    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
