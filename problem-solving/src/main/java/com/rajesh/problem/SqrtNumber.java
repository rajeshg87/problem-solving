package com.rajesh.problem;

import java.util.stream.*;

public class SqrtNumber {
	public static void main(String[] args) {
		int num=44;
		System.out.println(IntStream.iterate(num, i -> i / 2)
				.limit(num / 2 - 1)
				.filter(n -> n > 1)
				.peek(n -> System.out.println(n))
				.allMatch(n -> n % 2 == 0));
	}

}
