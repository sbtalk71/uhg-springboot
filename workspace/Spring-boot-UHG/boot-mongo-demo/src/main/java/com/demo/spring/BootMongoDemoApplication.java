package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@SpringBootApplication
public class BootMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMongoDemoApplication.class, args);
	}

	@Bean
	public MongoClient mongoClient() {
		MongoClient mongoClient=new MongoClient(new ServerAddress("localhost", 27017));
		return mongoClient;
	}
	
	@Bean
	public MongoTemplate mt() {
		MongoTemplate mt= new MongoTemplate(mongoClient(),"emp");
		return mt;
	}
}
