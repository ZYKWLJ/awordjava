package com.thread.Create4Ways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        newFixedThreadPool.submit(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("hello");
            };
        });
        newFixedThreadPool.shutdown();
    }
}
