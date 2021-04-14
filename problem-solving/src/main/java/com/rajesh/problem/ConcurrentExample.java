package com.rajesh.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public class ConcurrentExample {

	public static void main(String[] args) throws IOException {

		ExecutorService service = Executors.newFixedThreadPool(2);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> numbers = new ArrayList<Integer>();
		String line = "";
		while (!line.equals("exit")) {
			System.out.println(line);
			if (isNumber(line)) {
				numbers.add(Integer.parseInt(line));
			}
			line = reader.readLine();

		}

		Predicate<Integer> evenPredicate = i -> (i % 2) == 0;
		Predicate<Integer> oddPredicate = i -> (i % 2) != 0;

		Runnable task_1 = () -> printNumber(numbers, evenPredicate);
		Runnable task_2 = () -> printNumber(numbers, oddPredicate);
		
		service.submit(task_1);
		service.submit(task_2);
		service.shutdown();
		
		

	}

	private static boolean isNumber(String line) {
		try {
			Integer.parseInt(line);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static void printNumber(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream().filter(predicate)
				.forEach(n -> System.out.println(Thread.currentThread().getName() + " = " + n));
	}

}
