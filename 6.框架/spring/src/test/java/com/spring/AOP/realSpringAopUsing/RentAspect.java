package com.spring.AOP.realSpringAopUsing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RentAspect {

    // 前置通知，在目标方法执行之前执行
    @Before("execution(* com.spring.AOP.realSpringAopUsing.Host.rent())")
    public void beforeRent1(JoinPoint joinPoint) {
        System.out.println("中介开始宣传房屋。");
    }

    // 前置通知，在目标方法执行之前执行
    @Before("execution(* com.spring.AOP.realSpringAopUsing.Host.rent())")
    public void beforeRent2(JoinPoint joinPoint) {
        System.out.println("中介宣传房屋完毕。");
    }

    // 后置通知，在目标方法执行之后执行
    @After("execution(*  com.spring.AOP.realSpringAopUsing.Host.rent())")
    public void afterRent1(JoinPoint joinPoint) {
        System.out.println("中介收集客户反馈。");
    }

    // 后置通知，在目标方法执行之后执行
    @After("execution(*  com.spring.AOP.realSpringAopUsing.Host.rent())")
    public void afterRent2(JoinPoint joinPoint) {
        System.out.println("中介收集客户完毕。");
    }

}