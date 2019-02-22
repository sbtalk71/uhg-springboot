package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class MongoRepoTestRunner implements CommandLineRunner {

	@Autowired
	EmpMongoRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.insert(new Emp(110, "Dilip", "Hyderabad", 55000));
		
		repo.findAll().stream().forEach(System.out::println);
		//repo.stream().forEach(System.out::println);

	}

}
