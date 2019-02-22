package com.demo.spring;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BootRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRabbitmqApplication.class, args);
	}

	@Bean
	public RabbitTemplate rabbitTemplate( ConnectionFactory conn) {
		return new RabbitTemplate(conn);
	}
}
