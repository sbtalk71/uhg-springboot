package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages="com.demo.spring")
public class EmpReactiveMongoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpReactiveMongoRestApplication.class, args);
	}

}
