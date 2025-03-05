package com.edu.ThreadLocal.testSimple;

import java.util.concurrent.CountDownLatch;

public class SimpleExam {
    private final static ThreadLocal<Integer> TL = new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
            return 0;// 初始值设置为0
        };
    };

    public static void main(String[] args) throws InterruptedException {
        // 下面的内容中，线程1一定是输出5，线程2一定输出10！
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Integer x = TL.get();
                x += 5;
                TL.set(x);
                System.out.println(Thread.currentThread().getName() + " x==" + TL.get());
                TL.remove();
            }, "线程1").start();

            new Thread(() -> {
                Integer x = TL.get();
                x += 10;
                TL.set(x);
                System.out.println(Thread.currentThread().getName() + " x==" + TL.get());
                TL.remove();
            }, "线程2").start();
        }
    }
}
