package com.thread.ExitThread3Ways;

public class Flag extends Thread {
    public volatile boolean exitFlag = false;
    static int i = 0;

    @Override
    public void run() {
        while (!exitFlag) {
            System.out.println("hello,i am running now~" + i++);
        }
        System.out.println("crying,i am over now~");

    }

    public void setExitFlag(boolean exitFlag) {
        this.exitFlag = exitFlag;
    }

    public static void main(String[] args) throws InterruptedException {
        Flag flag = new Flag();
        System.out.println("the sub-thread is" + flag.interrupted());
        Thread.sleep(2000);
        flag.start();
        flag.setExitFlag(true);//主线程修改标志位来向附线程通信
        System.out.println("the sub-thread is " + flag.interrupted());
        Thread.sleep(2000);
    }
}
