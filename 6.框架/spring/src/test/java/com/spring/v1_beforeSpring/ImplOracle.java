package com.spring.v1_beforeSpring;

import org.springframework.stereotype.Component;

@Component
public class ImplOracle implements basicInterface{
    @Override
    public void showDBContect(){
        System.out.println("this is oracle!");
    }
}
