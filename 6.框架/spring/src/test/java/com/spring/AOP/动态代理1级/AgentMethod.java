package com.spring.AOP.动态代理1级;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 实现 InvocationHandler 接口
class AgentMethod implements InvocationHandler {
    private Object subject;

    public AgentMethod(Subject target) {
        this.subject = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ProxyHandler: Before request.");
        Object result = method.invoke(subject, args);
        System.out.println("ProxyHandler: After request.");
        return result;
    }
}