package com.in28minutes.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class BinarySearchImpl {

	
	private SortAlgorithm sortAlgorithm;
	
	
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}


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
