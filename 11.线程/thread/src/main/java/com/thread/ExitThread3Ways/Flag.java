package com.thread.ExitThread3Ways;

public class Flag extends Thread {
    public volatile boolean exitFlag = false;//volatile 关键字，是为了让主线程对标志位exitFALG的修改，能够立即被附线程识别到！
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
        System.out.println("the sub-thread is" + flag.isInterrupted());//这样才是附线程的判断！，是使用对象调用的！
        flag.start();
        flag.interrupt();
        Thread.sleep(2000);
        flag.setExitFlag(true);//主线程修改标志位来向附线程通信
        System.out.println("the sub-thread is " + flag.isInterrupted());
        System.out.println("Main Thread "+Thread.interrupted());
        Thread.sleep(2000);
    }
}
