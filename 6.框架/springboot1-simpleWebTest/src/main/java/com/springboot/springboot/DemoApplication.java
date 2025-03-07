package com.springboot.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {
  @Autowired
  private TestSpringAppName testSpringAppName;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  // 打印配置中的app名字！记得重写run方法，并且需要implement CommandLine~
  @Override
  public void run(String... args) throws Exception {
    System.out.println("this is my name~~");
    testSpringAppName.printApplicationName();
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }
}