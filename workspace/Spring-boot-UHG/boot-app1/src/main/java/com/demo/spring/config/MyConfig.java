package com.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public String hello() {
		return "Welcome to Spring Boot";
	}
}
