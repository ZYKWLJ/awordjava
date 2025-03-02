package com.thread.Lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Person {
    String name;
    int reminder;

    public Person(String name, int reminder) {
        this.name = name;
        this.reminder = reminder;
    }

    public String getName() {
        return name;
    }

    public int getReminder() {
        return reminder;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\t money:" + this.reminder;
    }
}

class CorrectBank {
    // 正确版本，注意只维护一个银行对象，所有客户用这一个锁！这样就保证所有对象共用一把锁了！
    private List<Person> bankConsumer = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition noMoreMoney = lock.newCondition();

    public void transfersTo(Person from, Person to, int amount) throws InterruptedException {
        lock.lock();
        try {
            while (from.reminder < amount) {
                System.out.println(
                    from.getName() + " wants to transfer to " + to.getName() + ", but its reminder is only "
                    + from.reminder + " , not enough for the amount "+amount+", so it is waiting for others to transfer money to itself");
                System.out.println(from.name + " is waiting...");
                noMoreMoney.await();
                System.out.println(from.name + " is awaken...");
            }
            from.reminder -= amount;
            to.reminder += amount;
            System.out.println(from.getName() + " transferred " + amount + " to " + to.getName() + ".");
            noMoreMoney.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public CorrectBank addPerson(Person person) {
        this.bankConsumer.add(person);
        System.out.println("Add consumer: " + person.toString());
        return this;
    }

    public List<Person> getBankConsumer() {
        return bankConsumer;
    }
}

public class TestCorrectBank {
    public static void main(String[] args) throws InterruptedException {
        Person A = new Person("A", 1000);
        Person B = new Person("B", 2000);
        Person C = new Person("C", 3000);
        final CorrectBank correctBank = new CorrectBank().addPerson(A).addPerson(B).addPerson(C);

        Thread A2B = new Thread(() -> {
            System.out.println("A2B.....");
            try {
                correctBank.transfersTo(correctBank.getBankConsumer().get(0),
                        correctBank.getBankConsumer().get(1), 1500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        A2B.start();
        new Thread(() -> {
            System.out.println("C2A.....");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                correctBank.transfersTo(correctBank.getBankConsumer().get(2),
                        correctBank.getBankConsumer().get(0), 600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        A2B.join();
        System.out.println("All transfers completed.");
    }
}