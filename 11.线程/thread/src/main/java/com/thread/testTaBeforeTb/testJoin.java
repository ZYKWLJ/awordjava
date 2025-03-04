package com.thread.testTaBeforeTb;

public class testJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("my first execute~");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("my second execute~~");
        });

        t1.start();
        t2.start();
        t2.join();
        System.out.println("my third execute~~~");
    }
}