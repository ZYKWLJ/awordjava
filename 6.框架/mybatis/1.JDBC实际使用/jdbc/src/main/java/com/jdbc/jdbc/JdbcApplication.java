package com.jdbc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 发送 GET 请求并获取响应
		String response = restTemplate.getForObject("http://localhost:3306/users", String.class);

		// 打印响应体
		System.out.println("Response Body: " + response);
	}

}
