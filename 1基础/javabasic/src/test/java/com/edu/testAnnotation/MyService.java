package com.edu.testAnnotation;

/**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-23 17:18
 **/
//3. 使用注解标记方法，在需要记录执行时间的方法上添加 @LogExecutionTime 注解。
public class MyService {
    @LogExecutionTime
    public void performTask() {
        // 模拟一个耗时任务
        try {
            Thread.sleep(200); // 休眠 2 秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task1: This Task have Annotation, its execute time will be record!");
    }

    public void anotherMethod() {
        System.out.println("Task2: This method is not annotated, its execute time is lost.");
    }
}