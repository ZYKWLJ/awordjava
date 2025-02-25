package com.spring.AOP.realSpringAopUsing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.spring.AOP.realSpringAopUsing")
@EnableAspectJAutoProxy
public class AppConfig {
}