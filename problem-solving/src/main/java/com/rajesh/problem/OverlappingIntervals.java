package com.rajesh.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class OverlappingIntervals {
	
	public static void main(String[] args) {
		int[][] input = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] output = calculate(input);
		Stream.of(output).forEach(i -> System.out.println(i[0]+" "+i[1]));
	}

	private static int[][] calculate(int[][] input) {
		Arrays.sort(input, (i1,i2) -> Integer.compare(i1[0], i2[0]));
		ArrayList< int[]> result = new ArrayList<>();
		result.add(input[0]);
		for(int i=1; i<input.length;i++) {
			if(input[i][0] <= result.get(result.size() - 1)[1]) {
				result.get(result.size() - 1)[1] = Math.max(input[i][1], result.get(result.size() - 1)[1]);
			}else {
				result.add(input[i]);
			}
		}
		result.stream().forEach(i -> System.out.println(i[0]+" "+i[1]));
		System.out.println("===============");
		return result.toArray(new int[result.size()][]);
	}

}
