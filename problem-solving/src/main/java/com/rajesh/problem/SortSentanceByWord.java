package com.rajesh.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortSentanceByWord{
	
	public static void main(String[] args) {
		String sentence = "Hi my name is Rajesh Kannan";
		
		System.out.println(Arrays.asList(sentence.split(" ")).stream()
			//.map(word -> new StringBuilder(word).reverse())
				.map(SortSentanceByWord::reverseWord)
			.collect(Collectors.joining(" "))
			);
		
		Stream.of("rajeshkannang".split("")).forEach(System.out::println);
	}
	
	public static Comparator<String> reverseSort = (s1, s2) -> s2.compareTo(s1);
	
	public static String reverseWord(String name) {
		return name.chars()
				.mapToObj(c -> (char)c)
				.map(String::valueOf)
				.sorted(reverseSort)
				.collect(Collectors.joining());
	}
}
