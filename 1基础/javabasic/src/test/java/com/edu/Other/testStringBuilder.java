package com.edu.Other;

import org.junit.Test;

public class testStringBuilder {
    @Test
    public void test(){
        String str="hello";
        StringBuilder rever=new StringBuilder(str);
        System.out.println(rever);
        rever.reverse();
        System.out.println(rever);



    }
}
