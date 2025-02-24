package com.edu;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Author: Ethan Yankang
 * @Program: awordjava
 * @Date: 2025-02-24 10:00
 **/
public class testMethodReference {
    @Test
    public void test(){
        Consumer<String> consumer=System.out::println;
        String[] strs={"123","abc","ABC","+-*/"};
        for (String str : strs) {
            consumer.accept(str);
        }
    }
}
