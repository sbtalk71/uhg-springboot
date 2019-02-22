package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.demo.spring")
public class JpaBootApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaBootApp1Application.class, args);
	}

}
