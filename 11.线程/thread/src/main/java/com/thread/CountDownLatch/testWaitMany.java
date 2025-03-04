package com.thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

// 让多个线程等待！
public class testWaitMany {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();//这10个线程会等待主线程执行，将计数器递减为0时才开始一起执行(类似于裁判发枪指令~)
                    System.out.println(Thread.currentThread().getName()+" running~~");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" running~~");
        countDownLatch.countDown();//发枪了，只不过在这时，主线程的任务已经执行完成了！
    }
}
