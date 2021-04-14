package com.rajesh.problem;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSeries {
	
	public static void main(String[] args) {
		
		System.out.println(fibonacciSeries(10));
		
		int prev=0, curr = 1;
		for(int i=0;i<50;) {
			i = prev + curr;
			prev = curr;
			curr = i;
			System.out.println(i);
			
		}
	}

	private static String fibonacciSeries(int series) {
		
		return Stream.iterate(new int[] {0,1}, t-> new int[]{t[1], t[0]+t[1]})
			  .limit(series)
			  .map(t -> t[0])
			  .map(String::valueOf)
			  .collect(Collectors.joining(","));
		
	}
	
	// A utility method that returns true if x is perfect square 
    static  boolean isPerfectSquare(int x) 
    { 
        int s = (int) Math.sqrt(x); 
        return (s*s == x); 
    } 
       
    // Returns true if n is a Fibonacci Number, else false 
    static boolean isFibonacci(int n) 
    { 
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both 
        // is a perfect square 
        return isPerfectSquare(5*n*n + 4) || 
               isPerfectSquare(5*n*n - 4); 
    } 

}