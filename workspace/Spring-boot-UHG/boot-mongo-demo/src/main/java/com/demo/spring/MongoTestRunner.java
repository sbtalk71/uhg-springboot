package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;


@Component
public class MongoTestRunner implements CommandLineRunner {
	@Autowired
	MongoTemplate mt;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(mt.findAll(Emp.class).stream().count());
		mt.findAll(Emp.class).stream().forEach(System.out::println);
		mt.find(new Query(Criteria.where("salary").gt(50000)), Emp.class).stream().forEach(System.out::println);

	}

}
