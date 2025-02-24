package com.edu;

import org.junit.Test;

import java.lang.invoke.VarHandle;
import java.util.Optional;

/**
 * @Author: Ethan Yankang
 * @Program: awordjava
 * @Date: 2025-02-24 09:30
 **/
public class testOptional {
    @Test
    //Java8之后有了Optional，就可以使用orElse()来规避nullptr了
    public void test1(){
        String name=null;
        Optional<String> optionalS=Optional.ofNullable(name);
        optionalS.ifPresent((str)-> System.out.println(str));//这里可以直接打印了。以前还需要判断值！
        String ret = optionalS.orElse("Null Pointer");
        System.out.println(ret);
    }
    //Java8之前必须使用if判断，不太好！
    @Test
    public void test2(){
        String name=null;
        if (name==null){
            System.out.println("Null Pointer");
        }
    }
}
