package com.edu.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestTenant {
    public static void main(String[] args) {
        HtmlRequest htmlRequest = new HtmlRequest();

        // 新创建线程，线程id不会出现重复，都是新创建的
        for (int i = 1; i <= 100; i++) {
            new Thread(htmlRequest).start();
        }
    }
}
