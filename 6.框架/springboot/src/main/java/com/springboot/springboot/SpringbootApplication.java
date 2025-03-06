package com.springboot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) throws InterruptedException {
		
		SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("hello~~~~~");
		Thread.sleep(10000);
	}

}
