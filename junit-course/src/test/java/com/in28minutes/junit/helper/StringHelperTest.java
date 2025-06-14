package com.in28minutes.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHelperTest {

	@Test
	void test() {
		StringHelper helper = new StringHelper();
		// AACD => CD, ACD => CD, CDEF => CDEF, CDAA => CDAA
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}

}
