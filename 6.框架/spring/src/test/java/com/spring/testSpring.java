package com.spring;
import org.junit.Test;
public class testSpring {
    basicInterface db=new ImplMysql();//这里是直接硬编码！
    @Test   
    public void testMysql(){
        // 调用MySQL的数据库
        db.showDBContect();
    }
    
    // @Test   
    // public void testOracle(){
    //     // 调用Oracle的数据库，就需要更改上面的db，所以很麻烦！
    //     db=new ImplOracle();
    //     db.showDBContect();
    // }
}
