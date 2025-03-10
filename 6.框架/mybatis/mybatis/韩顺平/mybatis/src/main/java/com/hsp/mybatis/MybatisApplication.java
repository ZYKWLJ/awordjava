package com.hsp.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 学习网站https://blog.csdn.net/weixin_45393094/article/details/136155002
@SpringBootApplication
@MapperScan("com.hsp.mybatis.mapper")
public class MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

}
