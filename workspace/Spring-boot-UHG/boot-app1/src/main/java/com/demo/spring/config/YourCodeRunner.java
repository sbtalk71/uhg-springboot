package com.demo.spring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("demo")
//@Order(value=1)
public class YourCodeRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Your Code Runner");

	}

}
