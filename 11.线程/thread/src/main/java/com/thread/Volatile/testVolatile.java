package com.thread.Volatile;

public class testVolatile {
    private static volatile boolean flag = false;
    // private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                flag = true;
            } catch (Exception e) {
                // TODO: handle exception
            }
        });

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (!flag) {
                System.out.println("循环" + i++ + "次,flag 仍未修改");
            }
            System.out.println("循环" + i++ + "次,flag 修改了");
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}