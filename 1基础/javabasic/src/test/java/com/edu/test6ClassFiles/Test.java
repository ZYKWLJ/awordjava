package com.edu.test6ClassFiles;

/**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-23 20:11
 **/
public class Test {
    @org.junit.Test
    public void testRecord(){
        Point point=new Point(1,4);
        System.out.println(point);
        System.out.println(point.area());
        System.out.println(point.hashCode());
    }

    public void testEnum(){
        //枚举类型的构造函数默认是私有的，并且枚举的实例是在枚举类型定义时就被创建好的
        //Days day= new Days("hello");
        System.out.println(Days.MONDAY);
    }
}
