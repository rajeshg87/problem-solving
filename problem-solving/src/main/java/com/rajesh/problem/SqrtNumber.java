package com.rajesh.problem;

import java.util.Scanner;
import java.util.stream.*;

public class SqrtNumber {
	public static void main(String[] args) {
		int num = 0;
		try(Scanner scanner= new Scanner(System.in)){
			num = scanner.nextInt();
			System.out.println(IntStream.iterate(num, i -> i>1, i -> i/2)
			//.boxed()
			.peek(n -> System.out.println(n))
			.allMatch(n -> n%2 == 0));
		}catch (Exception e) {
			System.out.println("Invalid Input :"+num);
		}
	}

}
