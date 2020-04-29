package com.rajesh.problem;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSeries {
	
	public static void main(String[] args) {
		
		System.out.println(fibonacciSeries(10));
		
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10)
				.forEach(arr -> System.out.println(arr[0] + " : " + arr[1]));
	}

	private static String fibonacciSeries(int series) {
		
		return Stream.iterate(new int[] {0,1}, t-> new int[]{t[1], t[0]+t[1]})
			  .limit(series)
			  .map(t -> t[0])
			  .map(String::valueOf)
			  .collect(Collectors.joining(","));
		
	}

}
