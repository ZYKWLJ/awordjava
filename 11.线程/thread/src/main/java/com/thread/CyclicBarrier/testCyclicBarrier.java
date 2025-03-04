package com.thread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class testCyclicBarrier {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);//若改成11，则程序永远阻塞，因为没有11个线程会到达栅栏，只有10个！
        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                try {
                    // Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "running~");
                        cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            if((i+1)%3==0){
                Thread.sleep(1000);
                System.out.println("第"+i/3+"组的3个线程达到，放行~~");
            }
        }   
        Thread.sleep(100);
        System.out.println("must wait all thread together, then next execute this task!");
    }
}
