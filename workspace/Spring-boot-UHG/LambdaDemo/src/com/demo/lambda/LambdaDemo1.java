package com.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaDemo1 {

	public static void main(String[] args) {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Inside Run...");

			}
		});

		// t.start();

		Thread t2 = new Thread(() -> System.out.println("Inside Run with lambda..."));

		// t2.start();

		List<String> names = Arrays.asList("John", "James", "Raju", "Kirthi", "Shantanu", null, "Shankar", "Ramu");

		names.stream().forEach(System.out::println);
		System.out.println(names.stream().count());

	//	names.stream().filter(s -> s.startsWith("S")).forEach(System.out::println);

		NullCheckPredicate np= new NullCheckPredicate();
		
		names.stream().filter(np).collect(Collectors.toList());
	}

	static class NullCheckPredicate implements Predicate<String> {

		@Override
		public boolean test(String t) {
			if (t == null)
				return false;
			else
				return true;
		}

	}
}
