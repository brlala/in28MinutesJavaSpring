package com.in28minutes.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIn5StepsApplication {

	//What are the beans?
	//What are the dependencies of a bean?
	//Where to search for beans?
	
	public static void main(String[] args) {
		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		int result = binarySearch.binarySearch(new int[] {24,16,3,8,5}, 8);
		System.out.println(result);
		SpringApplication.run(SpringIn5StepsApplication.class, args);
	}
}
