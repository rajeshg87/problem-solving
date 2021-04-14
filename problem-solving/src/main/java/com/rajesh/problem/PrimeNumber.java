package com.rajesh.problem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumber {
    public static void main(String[] args) {
        int count = 100;
        List<Integer> primeNumbers = Stream.iterate(2, n->n+1)
                .filter(x -> isPrime(x))
                .limit(count)
                .collect(Collectors.toList());

        System.out.println(primeNumbers);


    }

    private static boolean isPrime(int number) {
        return !IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .anyMatch(n -> number%n == 0);
    }
}

