package com.thread.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleConditionExample {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean conditionMet = false;

    public static void main(String[] args) {
        // 创建并启动等待线程
        Thread waitingThread = new Thread(() -> {
            
            lock.lock();
            try {
                System.out.println("等待线程获取到锁，开始检查条件...");
                while (!conditionMet) {
                    System.out.println("条件不满足，等待线程进入等待状态...");
                    condition.await();
                }
                System.out.println("条件满足，等待线程继续执行。");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });

        // 创建并启动唤醒线程
        Thread wakingThread = new Thread(() -> {
            try {
                // 模拟一些耗时操作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            lock.lock();
            try {
                System.out.println("唤醒线程获取到锁，开始改变条件...");
                conditionMet = true;
                System.out.println("条件已改变，唤醒所有等待线程...");
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        });


        // 启动两个线程
        waitingThread.start();
        wakingThread.start();

        // 等待两个线程执行完毕
        try {
            waitingThread.join();
            wakingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}