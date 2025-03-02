package com.thread.Create4Ways;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ImplCallable implements Callable {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 20; i++) {
            System.out.println("hello");
        }
        return "over!";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        ImplCallable implCallable = new ImplCallable();
        Future submit = newFixedThreadPool.submit(implCallable);
        String ret = (String) submit.get();
        System.out.println("result= "+ret);
        newFixedThreadPool.shutdown();
    }
}
