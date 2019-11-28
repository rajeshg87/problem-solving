package com.rajesh.problem;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSeries {
	
	public static void main(String[] args) {
		
		System.out.println(fibonacciSeries(10));
	}

	private static String fibonacciSeries(int series) {
		
		return Stream.iterate(new int[] {0,1}, t-> new int[]{t[1], t[0]+t[1]})
			  .limit(series)
			  .map(t -> t[0])
			  .map(String::valueOf)
			  .collect(Collectors.joining(","));
		
	}

}
