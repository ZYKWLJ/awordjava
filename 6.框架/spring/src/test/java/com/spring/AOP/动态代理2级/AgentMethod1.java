package com.spring.AOP.动态代理2级;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 实现 InvocationHandler 接口
class AgentMethod1 implements InvocationHandler {
    private Object subject;

    public AgentMethod1(Object target) {
        this.subject = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进行权限验证...");
        Object result = method.invoke(subject, args);
        System.out.println("权限验证成功...");
        return result;
    }
}