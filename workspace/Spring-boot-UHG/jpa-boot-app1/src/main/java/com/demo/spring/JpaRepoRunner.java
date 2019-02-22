package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class JpaRepoRunner implements CommandLineRunner {

	@Autowired
	EmpRepository repo;
	@Override
	public void run(String... args) throws Exception {
		
		repo.findAll().stream().forEach(System.out::println);
		
		
		Optional<Emp> o=repo.findById(1060);
		if(o.isPresent()) {
			System.out.println(o.get());
		}else {
			System.out.println("emp Not Found...");
		}

	}

}
