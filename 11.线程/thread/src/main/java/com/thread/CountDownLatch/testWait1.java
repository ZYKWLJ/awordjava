package com.thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class testWait1 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for ( int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"running~");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        
        System.out.println("All threads executes over~ this is main thread~");
    }
}