package com.rajesh.problem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class CustomCollector {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Rajesh", BigDecimal.valueOf(100000d)));
		persons.add(new Person("Lenin", BigDecimal.valueOf(200000d)));
		
		
		Collector<Person, StringJoiner, String> personNameCollector =
		        Collector.of(
		            () -> new StringJoiner(" | "),          		// supplier
		            (j, p) -> j.add(p.getName().toUpperCase()),  	// accumulator
		            (j1, j2) -> j1.merge(j2),              		 	// combiner
		            StringJoiner::toString); 
		
		
		System.out.println(persons.stream().collect(personNameCollector));
	}

}

class Person{
	private String name;
	private BigDecimal salary;
	
	public Person(String name, BigDecimal salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
