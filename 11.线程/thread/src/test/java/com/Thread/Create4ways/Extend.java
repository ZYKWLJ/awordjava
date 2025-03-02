package com.Thread.Create4ways;

import org.junit.Test;

public class Extend extends Thread {

    @Override
    public void run() {
        // TODO
        while (true) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        new Extend().start();
        
    }
}
