package com.in28minutes.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHelperTest {
	
	// AACD => CD, ACD => CD, CDEF => CDEF, CDAA => CDAA, BAADA => BADA
	
	StringHelper helper = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_AInFirst2Position() {
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AInFirstPosition() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testTruncaterAInFirst2Positions_AIsNotPresent() {
		assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AInLast2Positions() {
		assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
	}

	@Test
	public void testTruncateAInFirst2Positions_AInSecondPosition() {
		assertEquals("BADA", helper.truncateAInFirst2Positions("BAADA"));
	}
	
	// ABCD => false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_NotSame() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
//	ABAB => true
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Same() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
//	AB => true
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_LengthTwo() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
	
//	A => false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_LengthOne() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
	}
	
	
}
