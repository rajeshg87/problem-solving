package com.rajesh.problem;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArmStrong {
	
	public static void main(String[] args) {
		IntStream.iterate(1, i -> i+1)
				 .filter(num -> isArmStrong(num))
				 .limit(10)
				 .forEach(armStrongNum -> System.out.println(armStrongNum));
	}
	
	public static boolean isArmStrong(int num) {
		return Stream.of(String.valueOf(num).split(""))
				  .map(Integer::valueOf)
				  .map(n -> n*n*n)
				  .mapToInt(Integer::intValue)
				  .sum() == num;
	}

}
