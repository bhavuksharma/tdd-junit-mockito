package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockTestBDD {
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		// Given - setup
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn Java");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// When - actual method call
		List<String> filteredList = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		// Then - asserts
		assertThat(filteredList.size(), is(2));
		assertThat(filteredList.get(0), is("Learn Spring MVC"));
	}

	// learning verify() method 
	@Test
	public void deleteTodosNotRelatedToSpring_usingAMock() {
		
		// Given - setup
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn Java");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// When - actual method call
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		// Then - asserts
		verify(todoServiceMock, times(1)).deleteTodo("Learn Java");
		then(todoServiceMock).should().deleteTodo("Learn Java");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
	}
	
	// learning Argument Captor
	@Test
	public void deleteTodosNotRelatedToSpring_usingAMock_ArgumentCaptor() {
		
		// Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		// Define Argument Captor on specific method call
		// Capture the Argument
		
		// Given - setup
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Python", "Learn Spring",
				"Learn Java");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// When - actual method call
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		// Then - asserts
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
		
	}
}
