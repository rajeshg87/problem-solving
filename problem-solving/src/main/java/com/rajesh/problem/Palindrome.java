package com.rajesh.problem;

import java.util.stream.IntStream;

public class Palindrome {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("maddam"));
	}

	private static boolean isPalindrome(String text) {
		String temp = text.toLowerCase();
		return IntStream.range(0, temp.length()/2)
				.peek(a -> System.out.println(a +" - "+ (temp.length()-a-1)))
				 .allMatch(i -> temp.charAt(i) == temp.charAt(temp.length() - i -1));
	}

}
