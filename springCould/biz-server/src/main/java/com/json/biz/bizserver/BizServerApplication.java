package com.json.biz.bizserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.json.core"})
@MapperScan("com.json.core.dao")
public class BizServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BizServerApplication.class, args);
	}
}
