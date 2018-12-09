package com.in28minutes.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyMathTest {
	MyMath myMath = new MyMath();
	
	//JUnit cannot gurantee all methods will be run in order, before will run before every test
	@Before
	public void before() {
		System.out.println("Before");
	}
	
	//Used for cleanup
	@After
	public void after() {
		System.out.println("After");
	}
	
	//Before Class and AfterClass is class level method, such like static methods
	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}
	
	@Test
	public void sum_with3numbers() {
		
//		System.out.println(result);
		//compare expected value with value obtained
		System.out.println("Test 3 numbers");
		assertEquals(6, myMath.sum(new int[] {1,2,3}));
	}
	
	@Test
	public void sum_with1numbers() {
//		System.out.println(result);
		//compare expected value with value obtained
		System.out.println("Test 1 number");
		assertEquals(3, myMath.sum(new int[] {3}));
	}
}
