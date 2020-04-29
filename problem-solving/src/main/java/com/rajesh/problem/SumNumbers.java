package com.rajesh.problem;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SumNumbers {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(new Integer[] {0,1,2,3,4,5,6});
		Predicate<Integer> even = i -> i%2 != 0;
		Predicate<Integer> greaterThanTwo = i -> i > 2;
		Predicate<Integer> notEqualToFour = i -> i != 4;
		System.out.println(sum(numbers, even.and(greaterThanTwo).and(notEqualToFour)));
	}
	
	public static Integer sum(List<Integer> nums, Predicate<Integer> predicate) {
		System.out.println(nums.stream().filter(predicate).mapToInt(Integer::intValue).sum());
		return nums.stream().filter(predicate).reduce(0, (a,b) -> a+b);
	}

}
