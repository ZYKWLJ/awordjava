package com.thread.TestInterrupts;

public class testInterrupted {
    public static void main(String[] args) {
        System.out.println("当前中断状态: "+Thread.interrupted());
        System.out.println("调用interrupt方法将当前线程中断位设置为true");
        // 设置为中断位为true！
        Thread.currentThread().interrupt();
        // 第一次调用，返回 true 并清除中断状态
        System.out.println("当前中断状态: "+Thread.interrupted());
        System.out.println("因为检查方法interrupted()具有清除中断位的副作用，再次检测中断位");
        // 第二次调用，返回 false
        System.out.println("当前中断状态: "+Thread.interrupted());

    }
}
