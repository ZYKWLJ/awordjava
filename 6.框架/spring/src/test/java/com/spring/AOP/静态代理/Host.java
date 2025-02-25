package com.spring.AOP.静态代理;

public class Host implements Subject{
    @Override
    public void rent(){
        System.out.println("hey, this is Host, my houst is rent to you~");
    }
}
