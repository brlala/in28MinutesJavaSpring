package com.in28minutes.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	//it will find classes with @Component that implements sortAlgorithm
	private SortAlgorithm sortAlgorithm;
	
	//Constructor injection - mandatory injection
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}
	
//	//Setter injection - for optional injection
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

	public int binarySearch(int[] numbers, int numberToSearch) {
		//Implementing Sorting Logic
		//Bubble Sort Algorithm
		int [] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		
		//Search the array
		//return
		return 3;
	}
}
