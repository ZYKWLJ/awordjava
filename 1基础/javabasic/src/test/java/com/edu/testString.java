package com.edu; /**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-22 21:20
 **/
import org.junit.Test;
public class testString {
    @Test
    public void test1(){
        System.out.println("测试String类的常用方法");
        String s1 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("1.基本方法\n");
        System.out.println("length()="+s1.length()+"\nisEmpty()="+s1.isEmpty());
        System.out.println("2.子串操作\n");
    }
}
