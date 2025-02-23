package com.edu.testAnnotation;

/**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-23 17:17
 **/
import java.lang.reflect.Method;
//创建切面类，用于在方法执行前后记录时间
public class LogExecutionTimeAspect {
    public static void logExecutionTime(Object target, Method method, Object[] args) throws Exception {
        // 获取方法上的注解
        // 如果方法上有这个注解
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.currentTimeMillis(); // 记录开始时间
            //显然就只是在执行方法的基础上，两边增加了额外一些操作，而这个是通过注解来触发的！
            // 执行方法
            method.invoke(target, args);

            long endTime = System.currentTimeMillis(); // 记录结束时间
            long executionTime = endTime - startTime; // 计算执行时间

            System.out.println("Method " + method.getName() + " executed in " + executionTime + " ms");
        } else {
            // 如果没有注解，直接执行方法
            method.invoke(target, args);
        }
    }
}