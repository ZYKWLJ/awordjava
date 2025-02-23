package com.edu.testAnnotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-23 17:19
 **/
//总流程：
//    1.创建使用了注解的类的实例
//    2.反射获取到使用注解的类的目标方法
//    3，将注解类的实例与获取到的目标方法传入切面类中，通过Method.invoke(obj,method)执行实例的方法
//    4.总之我们的多余的工作就是在切面类里面执行的，切面类里面保证了我们在执行原始方法之上，添加了一些额外的操作，而这个操作，使用注解来触发

public class testAnnotation {
    @Test
    public void test() throws Exception {
        //创建类实例
        MyService myService = new MyService();
        // 通过反射，获取 MyService 类的方法
        Method performTaskMethod = MyService.class.getMethod("performTask");
        Method anotherMethodMethod = MyService.class.getMethod("anotherMethod");
        // 调用切片类，传入类实例与获取到的该类上面的方法，调用方法它们并记录执行时间
        LogExecutionTimeAspect.logExecutionTime(myService, performTaskMethod, null);
        LogExecutionTimeAspect.logExecutionTime(myService, anotherMethodMethod, null);
    }
}
