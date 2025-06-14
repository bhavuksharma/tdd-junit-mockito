package com.in28minutes.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
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
	
	@Test
	public void testArraySort_NullArray() {
		assertThrows(NullPointerException.class, () -> {
			int[] numbers = null;
			Arrays.sort(numbers);
		});	
	}
	
	@Test
	public void testArraySort_Performance() {
		
		assertTimeout(Duration.ofMillis(100), () -> {
			int[] numbers = {12,5,43};
			for(int i = 1 ; i < 1000000 ; i++) {
				numbers[0] = i;
				Arrays.sort(numbers);
			}
		});
		
		
	}

}
