package com.edu;

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
