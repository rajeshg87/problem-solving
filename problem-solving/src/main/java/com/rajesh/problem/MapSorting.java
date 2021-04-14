package com.rajesh.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapSorting {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("R", "A", "B", 
				"C", "D", "E", "F");
		
		AtomicInteger index=new AtomicInteger();
		Map<Integer, String> nameMap = names.stream()
				.collect(Collectors.toMap(k -> index.incrementAndGet(), Function.identity()));
		
		System.out.println(nameMap);
		
		//Sort Map by Value
		Comparator<Map.Entry<Integer, String>> valueComparator = Map.Entry.comparingByValue();
		
		Map sortByValue = nameMap.entrySet()
					.stream()
					.sorted(valueComparator)
					.collect(Collectors.toMap(e -> e.getKey(), e ->  e.getValue(), (e1,e2) -> e1, LinkedHashMap::new));

		System.out.println(sortByValue);
		
		//Sort Map by Key
		Comparator<Map.Entry<Integer, String>> keyComparator = Map.Entry.comparingByKey();
		
		System.out.println(nameMap.entrySet()
				.stream()
				.sorted(keyComparator)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue)));
		
		System.out.println(nameMap.entrySet().stream().collect(Collectors.groupingBy(entry -> entry.getValue())));
		
		
	}

}
