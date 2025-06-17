package com.in28minutes.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List<String> arrayList = spy(ArrayList.class);
		assertEquals(0, arrayList.size());
		
		arrayList.add("dummy");
		verify(arrayList).add("dummy");
		assertEquals(1, arrayList.size());
		
		given(arrayList.size()).willReturn(5);
		assertThat(arrayList.size(), is(5));
	}

}
