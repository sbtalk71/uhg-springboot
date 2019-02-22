package com.demo.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
//@Order(value=2)
public class MyCodeRunner implements CommandLineRunner {

	@Autowired
	@Qualifier("hello")
	String msg;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(msg);

	}

}
