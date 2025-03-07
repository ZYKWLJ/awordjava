package com.springboot.springboot;
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class TestSpringAppName {
    @Autowired
    private  Environment environment;

    public  void printApplicationName() {
        String applicationName = environment.getProperty("spring.application.name");
        System.out.println("Application name: " + applicationName);
    }
}
