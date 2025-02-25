package com.spring.IOC.v1_beforeSpring;

import org.springframework.stereotype.Component;

@Component
public class ImplMysql implements basicInterface{
    @Override
    public void showDBContect(){
        System.out.println("this is MySQL~");
    }
}
