package com.thread.Synchronized;

class Bank {
    int remainer;// 剩余的钱
    String name;// 开户人
    // private final ReentrantLock lock = new ReentrantLock();
    // private Condition bankRemainerIsless = lock.newCondition();// 创建一个余额不足的条件变量

    public Bank(int remainer, String name) {
        this.remainer = remainer;
        this.name = name;
    }

    public int getRemainer() {
        return remainer;
    }

    public String getName() {
        return name;
    }

    // 给别人转账
    public void transferToOther(Bank to, int amount) throws InterruptedException {
        synchronized (Bank.class) {//这样用synchronized给整个类对象加锁！
            while (this.remainer < amount) {
                System.out.println(
                        this.name + " wants to transfer " + amount + " to " + to.getName() + " ,but " + this.name
                                + " 's remainer is " + this.remainer + " ,not enough, waiting other transfer to it...");
                System.out.println(this.name + " is waiting...");
                Bank.class.wait();
                System.out.println(this.name + " is awakened...");
            }

            this.remainer -= amount;
            to.remainer += amount;
            System.out.println(this.name + " has transferred " + amount + "￥ to " + to.name + ", Now " + to.name
                    + " 's amount is " + to.remainer);
            Bank.class.notifyAll();
            System.out.println(this.name + " called the notifyAll()....");
        }
    }
}

public class testBankSynchronized2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is running--Main\n");

        Bank A = new Bank(1000, "A");
        Bank B = new Bank(2000, "B");
        // 创建转账线程
        Thread A2B = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running--A2B");
            try {
               A.transferToOther(B, 1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        A2B.start();
        Bank C = new Bank(1000, "C");
        Thread C2A = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running--C2A");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                C.transferToOther(A, 600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
        });
        C2A.start();

        // 确保主线程是必须等到A2B完成时才退出！
        try {
            A2B.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
