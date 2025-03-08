package com.spring.AOP.动态代理1级 ;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        // 创建真实对象
        Subject subject = new Host();
        
        // 创建代理对象的增强型方法
        AgentMethod agentMethod = new AgentMethod(subject);

        // 创建代理对象实例
        Subject newProxyInstance = 
                (Subject) Proxy.newProxyInstance
                (Host.class.getClassLoader(),
                Host.class.getInterfaces(), 
                agentMethod);

        // 调用代理的接口！
        newProxyInstance.rent();
    }
}
