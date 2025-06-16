package com.in28minutes.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> scores = List.of(34,53,64,25);
	
		// Asserts
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(34,53));
		
		// every item: > 90
		assertThat(scores, everyItem(greaterThan(20)));
		assertThat(scores, everyItem(lessThan(100)));
		
	}

}
