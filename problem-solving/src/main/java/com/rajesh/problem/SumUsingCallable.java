package com.rajesh.problem;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumUsingCallable {
	
	public static void main(String[] args) {
		
		ExecutorService service=Executors.newFixedThreadPool(2);
		
		List<Integer> nums = IntStream.iterate(1, i -> i+1)
								.limit(5)
								.boxed()
								.peek(System.out::println)
								.collect(Collectors.toList());
		
		//SumCalculator sumCalculator1=new SumCalculator(nums.subList(0, nums.size()/2));
		
		Callable<Integer> sum1 = () -> nums.subList(0, nums.size()/2).stream().mapToInt(Integer::valueOf).sum();
		Callable<Integer> sum2 = () -> nums.subList(nums.size()/2, nums.size()).stream().mapToInt(Integer::valueOf).sum();
		
		//SumCalculator sumCalculator2=new SumCalculator(nums.subList(nums.size()/2, nums.size()));
		
		//System.out.println("SET 1 : "+nums.subList(0, nums.size()/2));
		//System.out.println("SET 2 : "+nums.subList(nums.size()/2, nums.size()));
		
		
		Future<Integer> tot_1 = service.submit(sum1);
		Future<Integer> tot_2 = service.submit(sum2);
		
		try {
			Integer  total = tot_1.get().intValue() + tot_2.get().intValue();
			System.out.println("Total : "+total);
		}catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		service.shutdown();
		
	}

}