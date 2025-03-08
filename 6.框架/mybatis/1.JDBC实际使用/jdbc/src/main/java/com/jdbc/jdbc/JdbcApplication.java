package com.jdbc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JdbcApplication{
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(JdbcApplication.class, args);
	}
}
