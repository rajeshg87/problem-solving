package com.rajesh.problem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {
	
	public static void main(String[] args) {
		System.out.println(primeNumbers(20));
	}

	private static List<Integer> primeNumbers(int max) {
		return IntStream.range(2, max)
						.filter(n -> isPrime(n))
						.boxed()
						.collect(Collectors.toList());
	}

	private static boolean isPrime(int n) {
		return IntStream.rangeClosed(2, (int)Math.sqrt(n)).allMatch(i -> n % i != 0);
	}

}
