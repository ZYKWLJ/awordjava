package com.thread.Create4Ways;

public class ImplRunnable {
    public static void main(String[] args) {
        new Thread(()->{
            while (true) {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
