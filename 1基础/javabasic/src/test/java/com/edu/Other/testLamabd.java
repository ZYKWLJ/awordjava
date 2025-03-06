package com.edu.Other;

import org.junit.Test;

/**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-23 11:11
 **/
@FunctionalInterface//这里加与不加都可以，只是方便编译器检查是不是唯一的抽象方法
interface MyFunc{
    void doSomething(String str);
}
@FunctionalInterface//这里加与不加都可以，只是方便编译器检查是不是唯一的抽象方法
interface MyFunc1{
    void doSomething1(String str,int repeat);
}
public class testLamabd {
    @Test
    public void test1(){
        MyFunc myFunc= (str)-> {
            System.out.println("str~~");
        };//lamabd就相当于是接口的一个实例，传给这个接口，这样接口的具体功能就确定了！
        myFunc.doSomething("hello");
        MyFunc1 myFunc1=(str,num)->{
            System.out.println(str.repeat(num));
        };
        myFunc1.doSomething1("hello~~",5);
    }
}
