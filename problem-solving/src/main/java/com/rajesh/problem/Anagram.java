package com.rajesh.problem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagram {
	public static void main(String[] args) {
		
		System.out.println(isPrime(8));
		
		List<Integer> primes = IntStream.iterate(2, i -> i+1).filter(i -> isPrime(i))
		.limit(10).boxed().collect(Collectors.toList());
		
		System.out.println(primes);
		
		String s1 = "rajesh", s2 = "eshraj";
		
		System.out.println(sortString(s1).equals(sortString(s2)));
		
		int[] nums = {2,1,3,0,7,8,9,0,3,5,0};
		
		IntStream.of(nums).sorted().forEach(System.out::println);
		
		Integer i1 = 129;
		Integer i2 = 129;
		Integer i3 = 128;
		System.out.println(i1.hashCode()+" "+i2.hashCode());
		System.out.println(i3.hashCode());
		System.out.println(i1==i2);
		System.out.println(i1==i3);
		
	}

	private static String sortString(String s1) {
		return s1.chars().mapToObj(c -> (char) c)
				.map(String::valueOf).sorted().collect(Collectors.joining());
	}

	private static Boolean isPrime(int i) {
		return IntStream.rangeClosed(2, (int)Math.sqrt(i))
				//.peek(n -> System.out.println(i+" = "+n))
				.allMatch(n -> (i%n) != 0);
	}

}
