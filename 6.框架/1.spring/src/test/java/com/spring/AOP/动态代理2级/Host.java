package com.spring.AOP.动态代理2级;

public class Host implements Subject{
    @Override
    public void rent(){
        System.out.println("hey, this is Host, my houst is rent to you~");
    }
}
