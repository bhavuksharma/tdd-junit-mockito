package com.in28minutes.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> scores = List.of(34,53,64,25);
	
		// Asserts related to integer list
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(34,53));
		assertThat(scores, everyItem(greaterThan(20)));
		assertThat(scores, everyItem(lessThan(100)));
		
		// Asserts of String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		// Asserts of Arrays
		Integer[] marks = {1,2,3,4};
		assertThat(marks, arrayWithSize(4));
		assertThat(marks, arrayContaining(1,2,3,4));
		assertThat(marks, arrayContainingInAnyOrder(3,1,2,4));
		
	}

}
