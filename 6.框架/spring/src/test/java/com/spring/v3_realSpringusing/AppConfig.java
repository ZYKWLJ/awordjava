package com.spring.v3_realSpringusing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Configuration 注解表示这是一个 Spring 配置类
@ComponentScan(basePackages = "com.spring.v1_beforeSpring")
// @ComponentScan 注解指定了要扫描的包路径，Spring 会自动扫描该路径下的所有带有 @Component、@Service 等注解的类。
public class AppConfig {

}