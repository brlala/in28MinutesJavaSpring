package com.in28minutes.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	//What are the beans? @Components
	//What are the dependencies of a bean? @Autowired
	//Where to search for beans? @SpringBootApplication
	
	public static void main(String[] args) {
		
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		
//		All beans will be created in Application Context, we want bean of binarySearchImpl
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int[] {24,16,3,8,5}, 8);
		System.out.println(result);
		
		
	}
}
