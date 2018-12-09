package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssertTest {

	@Test
	void test() {
		//Check whether value is equal
		assertEquals(1, 1);
		assertNotEquals(unexpected, actual);
		
		//Check if condition is true/false
		assertTrue(true);
		assertFalse(false);
		
		//Check if condition is null
		assertNull(actual);
		assertNotNull(actual);
		
		//Check array
		assertArrayEquals(expected, actual);
	}

}
