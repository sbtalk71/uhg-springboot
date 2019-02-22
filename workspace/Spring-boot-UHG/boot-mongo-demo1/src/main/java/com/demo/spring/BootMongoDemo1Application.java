package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.demo.spring")
public class BootMongoDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMongoDemo1Application.class, args);
	}

	/*@Bean
	public MongoClient mongoClient() {
		MongoClient mc = new MongoClient(new ServerAddress("localhost", 27017));
		return mc;
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		MongoTemplate mt = new MongoTemplate(mongoClient(), "test");
		return mt;
	}*/
}
