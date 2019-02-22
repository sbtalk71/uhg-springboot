package com.demo.spring;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.spring.entity.Emp;

public class GetReactiveCLient {

	public static void main(String[] args) throws Exception {
		WebClient client=WebClient.create("http://localhost:8090");
		
		client
		.get()
		.uri("/emp2/list")
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToFlux(Emp.class)
		.subscribe(System.out::println);
		
		
		client
		.get()
		.uri("/emp2/list")
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToFlux(Emp.class).log()
		.subscribe(new Subscriber<Emp>() {

			Subscription s;
			int count=0;
			@Override
			public void onSubscribe(Subscription s) {
				this.s=s;
				s.request(2);
							
			}

			@Override
			public void onNext(Emp t) {
				System.out.println(t);
				count++;
				if(count%2==0) {
					s.request(2);
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onComplete() {
			System.out.println("Processing done!!");
				
			}
			
		} );
		
		
		System.in.read();

	}

}
