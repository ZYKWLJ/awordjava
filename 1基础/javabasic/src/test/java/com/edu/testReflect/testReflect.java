package com.edu.testReflect;

import org.junit.Test;

/**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-23 18:08
 **/
public class testReflect {

    @Test
    public void test() throws ClassNotFoundException {
        Student student=new Student();
        //获取Class对象的3种方法：
        // 1.实例.getClass()
        //输出：class <包名>.<类名>
        System.out.println(student.getClass());
        // 2..class属性
        // 任何类型都有.class属性
        System.out.println(int.class);
        System.out.println(Student.class);
        //3.Class.forName(类路径)//注意这里是全类名，也就是包名到类名的路径！
        System.out.println(Class.forName("com.edu.testReflect.Student"));
    }
}
