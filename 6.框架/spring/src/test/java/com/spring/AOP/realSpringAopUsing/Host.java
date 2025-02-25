package com.spring.AOP.realSpringAopUsing;

import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

@Component
public class Host implements rentService{
    @Override
    public void rent(){
        System.out.println("hey, this is Host, my houst is rent to you~");
    }
}
