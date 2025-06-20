package com.virtualpairprogrammers.isbntools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateISBNTest {

	@Test
	public void checkAValid10DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue(result,"first value");
		result = validator.checkISBN("0140177396");
		assertTrue(result,"second value");
	}
	
	@Test 
	public void checkAValid13DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9789387779846");
		assertTrue(result,"first value");
		result = validator.checkISBN("9780099549482");
		assertTrue(result,"second value");
	}
	
	@Test
	public void tenDigitISBNNumbersEndingWithXAreValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void check10DigitInvalidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void check13DigitInvalidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9789387779847");
		assertFalse(result);
	}
	
	@Test
	public void nineDigitISBNsAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		
		assertThrows(NumberFormatException.class, 
				() -> {validator.checkISBN("123456789");});
	}
	
	@Test
	public void nonNumericISBNsAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		
		assertThrows(NumberFormatException.class, () -> {
			validator.checkISBN("helloworld");
		});
	}

}
