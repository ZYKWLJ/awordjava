package com.thread.TestInterrupts;

public class testisInterrupted {
    public static void main(String[] args) {
        System.out.println("当前线程中断状态: " + Thread.currentThread().isInterrupted());
        System.out.println("调用interrupt方法将当前线程中断位设置为true");
        // 设置为中断位为true！
        Thread.currentThread().interrupt();
        // 第一次调用，返回 true 并清除中断状态
        System.out.println("当前中断状态: " + Thread.currentThread().isInterrupted());
        System.out.println("因为检查方法isInterrupted()没有任何副作用，再次检测中断位依然是一样的");
        // 第二次调用，返回 false
        System.out.println("当前中断状态: " + Thread.currentThread().isInterrupted());

    }
}
