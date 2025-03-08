package com.spring.IOC.v3_realSpringusing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.IOC.v1_beforeSpring.basicInterface;
@Component
//@Service 注解用于将 EmailService 类标记为 Spring 管理的服务组件，Spring 会自动扫描并将其注册到应用上下文中。
public class DBImpl implements basicInterface{
    private final basicInterface bInterface;
    @Autowired
    public DBImpl(basicInterface bInterface){
        this.bInterface=bInterface;
    }
    public void showDBContect() {
        bInterface.showDBContect();
    }
    
}
