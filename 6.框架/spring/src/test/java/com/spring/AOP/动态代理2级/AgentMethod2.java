package com.spring.AOP.动态代理2级;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 实现 InvocationHandler 接口
class AgentMethod2 implements InvocationHandler {
    private Object subject;

    public AgentMethod2(Object target) {
        this.subject = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进行身份验证...");
        Object result = method.invoke(subject, args);
        System.out.println("身份验证成功...");
        return result;
    }
}