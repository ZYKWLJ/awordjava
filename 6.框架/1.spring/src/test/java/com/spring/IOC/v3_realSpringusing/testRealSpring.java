package com.spring.IOC.v3_realSpringusing;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.IOC.v1_beforeSpring.ImplMysql;
import com.spring.IOC.v1_beforeSpring.ImplOracle;
import com.spring.IOC.v1_beforeSpring.basicInterface;

public class testRealSpring {
    @Test
    public void test(){
        // 创建 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // basicInterface bean = context.getBean(ImplMysql.class);
        basicInterface bean = context.getBean(ImplOracle.class);
        bean.showDBContect();
        bean=context.getBean(ImplMysql.class);
        bean.showDBContect();
    }
}
