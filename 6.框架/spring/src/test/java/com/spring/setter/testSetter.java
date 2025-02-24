package com.spring.setter;

import org.junit.Test;

import com.spring.ImplMysql;
import com.spring.ImplOracle;

public class testSetter {
    private DBImpl db =new DBImpl();
    // 最大的区别就是将创建对象的工作封装了起来，成为了一个接口！
    // 这样我们创建对象就是在接口里面完成的了，不再是由程序员直接创建了!
    @Test
    public void test(){
        db.setDB(new ImplMysql());
        db.showDBContect();
        db.setDB(new ImplOracle());
        db.showDBContect();
    }
}
