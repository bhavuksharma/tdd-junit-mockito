package com.in28minutes.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArraysCompareTest {

	@Test
	void testArraySort_RandomArrays() {
		int[] actual = {12,8,4,3,1};
		int[] expected = {1,3,4,8,12};
		
		Arrays.sort(actual);
		
		assertArrayEquals(expected, actual);
	}

}
