package com.demo.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitRestRunner implements CommandLineRunner {

	@Autowired
	RabbitTemplate rt;
	@Override
	public void run(String... args) throws Exception {
		rt.convertAndSend("testQueue","Hi, how are doing");
		System.out.println("Message sent...");
		
		String msg=(String)rt.receiveAndConvert("testQueue");
		System.out.println("Received : "+msg);
		rt.stop();

	}

}
