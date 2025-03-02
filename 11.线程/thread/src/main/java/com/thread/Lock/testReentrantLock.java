package com.thread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task {
    private final Lock lock = new ReentrantLock();
    public void tryLock(){
       lock.lock();
       try  {
        System.out.println("Task is being running");
       } finally {
        lock.unlock();
       }
    }
}

public class testReentrantLock {
    public static void main(String[] args) {
        Task task = new Task();
        task.tryLock();
    }
}
