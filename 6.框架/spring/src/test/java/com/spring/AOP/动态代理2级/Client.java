package com.spring.AOP.动态代理2级 ;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        // 创建真实对象
        Subject subject = new Host();
        
        // 创建代理对象的1级增强型方法
        AgentMethod1 agentMethod1 = new AgentMethod1(subject);

        // 创建1级代理对象实例
        Subject newProxyInstance1 = 
                (Subject) Proxy.newProxyInstance
                (Host.class.getClassLoader(),
                Host.class.getInterfaces(), 
                agentMethod1);
         // 创建代理对象的2级增强型方法
         AgentMethod2 agentMethod2= new AgentMethod2(newProxyInstance1);

         // 创建2级代理对象实例
         Subject newProxyInstance2 = 
                 (Subject) Proxy.newProxyInstance
                 (Host.class.getClassLoader(),
                 Host.class.getInterfaces(), 
                 agentMethod2);
 
        // 调用代理的接口！
        newProxyInstance2.rent();
    }
}
