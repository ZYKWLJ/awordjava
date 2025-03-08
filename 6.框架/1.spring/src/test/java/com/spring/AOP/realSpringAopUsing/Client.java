package com.spring.AOP.realSpringAopUsing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        // 创建 Spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 从 Spring 上下文中获取 RentService 实例
        rentService rentService = context.getBean(rentService.class);//注意Spring是通过接口来管理AOP的，所以只能传入接口的.class
        // 调用租房方法
        rentService.rent();
        // 关闭 Spring 上下文
        context.close();
    }
}
