package com.spring.AOP.静态代理;

public class Agent implements Subject{
    Subject host=new Host();
    
    public Agent(Subject host) {
        this.host = host;
    }

    @Override
    public void rent() {
       System.out.println("hey, this is agent, i will contect you with the host~~");
       this.host.rent();
    }
}
