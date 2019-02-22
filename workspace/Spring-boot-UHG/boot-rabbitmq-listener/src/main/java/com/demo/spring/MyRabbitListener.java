package com.demo.spring;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "testQueue")
@Component
public class MyRabbitListener {

	public MyRabbitListener() {
		System.out.println("Listening...");
	}
	
	@RabbitHandler
	public void receive(String in) {
		System.out.println("Message Received : "+in);
	}
}
