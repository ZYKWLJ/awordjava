package com.thread.Volatile;

public class testVolatile2Atmotic {
    // 使用 volatile 关键字修饰变量
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int time = 0; time < 100; time++) {//测试100次，看看有多少次不满足原子性的！
            count = 0;
            // 创建两个线程
            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            });

            // 启动线程
            thread1.start();
            thread2.start();

            // 等待两个线程执行完毕
            thread1.join();
            thread2.join();
            System.out.println("Final count: " + count);

        }
        // 输出最终结果
        System.out.println("Experiment Over!");
    }
}
