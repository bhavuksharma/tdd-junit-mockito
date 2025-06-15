package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSize() {
			List listMock = mock(List.class);
			when(listMock.size()).thenReturn(2);
			
			assertEquals(2, listMock.size());
			assertEquals(2, listMock.size());
			assertEquals(2, listMock.size());
	}
	
	@Test
	public void letsMockListSize_ReturnMultipleValues() {
			List listMock = mock(List.class);
			when(listMock.size()).thenReturn(2).thenReturn(3);
			
			assertEquals(2, listMock.size());
			assertEquals(3, listMock.size());
	}
	
	@Test
	public void letsMockListGet() {
			List listMock = mock(List.class);
			//argument matchers
			when(listMock.get(anyInt())).thenReturn("working");
			
			assertEquals("working", listMock.get(0));
			assertEquals("working", listMock.get(1));
	}
	
	@Test
	public void letsMockListGet_BDD() {
		
		// Given
		List<String> listMock = mock(List.class);
		//argument matchers
		given(listMock.get(anyInt())).willReturn("working");
		
		// When
		String firstElement = listMock.get(0);
		String secondElement = listMock.get(1);
		
		// Then
		assertThat(listMock.get(0), is(firstElement));
		assertThat(listMock.get(1), is(secondElement));
	}
	
	
	@Test(expected = RuntimeException.class)
	public void letsMockList_throwAnException() {
			List listMock = mock(List.class);
			//argument matchers
			when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
			
			listMock.get(1);
	}
	
	
	@Test
	public void letsMockListGetIndexOf() {
		List listMock = mock(List.class);
		when(listMock.indexOf(anyInt())).thenReturn(0);
		
		assertEquals(0, listMock.indexOf(5));
	}
	
	
	

}
