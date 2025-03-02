package com.thread.TestInterrupts;

import java.util.concurrent.CountDownLatch;

public class testInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {//只有当线程处于阻塞，如调用sleep()、wait()、join() 等方法时，才会调用异常！不然只是置中断位为true！
                System.out.println("线程被中断：" + e.getMessage());
            }
        });
        thread.start();
        Thread.sleep(500);
        // thread.interrupt();// 主线程中断附线程
    }

}
