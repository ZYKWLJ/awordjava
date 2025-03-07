package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// 处理前端的请求体，也叫Control

@RestController // 包含注解@Controller and @ResponseBody
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	// 这个返回类型会自动转化为json
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/int")
	// 这个返回类型会自动转化为json
	// 可以允许方法名字一样，但是类型不同！
	public String greetingInt(Integer integer) {
		return String.valueOf(10);
	}
}
