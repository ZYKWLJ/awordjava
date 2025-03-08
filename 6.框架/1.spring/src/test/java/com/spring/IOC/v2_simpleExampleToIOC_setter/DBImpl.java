package com.spring.IOC.v2_simpleExampleToIOC_setter;

import com.spring.IOC.v1_beforeSpring.basicInterface;

public class DBImpl implements basicInterface {
    private basicInterface DBInterface;//最大的区别在这，这里只声明不创建，后面由setter创建(就这一步！)
    // 利用set实现
    // 再需要创建实例的时候，不去创建，而是实现一个接口，后面传入实例！
    public void setDB(basicInterface DBInterface){
        this.DBInterface=DBInterface;
    }
    @Override
    public void showDBContect(){
        this.DBInterface.showDBContect();
    }
}
