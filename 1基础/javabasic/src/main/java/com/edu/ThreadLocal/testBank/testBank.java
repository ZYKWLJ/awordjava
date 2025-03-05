package com.edu.ThreadLocal.testBank;

public class testBank {
    // 创建一个 ThreadLocal 对象，用于存储每个线程的账户余额
    private static final ThreadLocal<Integer> accountBalance = new ThreadLocal<Integer>() {
        // 重写 initialValue 方法，为每个线程的副本提供初始值
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    // 存款方法
    public static void deposit(int amount) {
        // 获取当前线程的账户余额
        int balance = accountBalance.get();
        // 增加存款金额
        balance += amount;
        // 更新当前线程的账户余额
        accountBalance.set(balance);
        System.out.println(Thread.currentThread().getName() + " 存款 " + amount + " 元，当前余额: " + balance + " 元");
    }

    // 取款方法
    public static void withdraw(int amount) {
        // 获取当前线程的账户余额
        int balance = accountBalance.get();
        if (balance >= amount) {
            // 减少取款金额
            balance -= amount;
            // 更新当前线程的账户余额
            accountBalance.set(balance);
            System.out.println(Thread.currentThread().getName() + " 取款 " + amount + " 元，当前余额: " + balance + " 元");
        } else {
            System.out.println(Thread.currentThread().getName() + "想取款 "+amount+" 元， 余额不足，取款失败！当前余额: " + balance + " 元");
        }
    }

    public static void main(String[] args) {
        // 创建两个线程，模拟两个客户
        Thread client1 = new Thread(() -> {
            deposit(1000);
            withdraw(500);
        }, "客户 1");

        Thread client2 = new Thread(() -> {
            deposit(2000);
            withdraw(3000);
        }, "客户 2");

        // 启动线程
        client1.start();
        client2.start();

        try {
            // 等待两个线程执行完毕
            client1.join();
            client2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 清除 ThreadLocal 中的数据，避免内存泄漏
        accountBalance.remove();
    }
}