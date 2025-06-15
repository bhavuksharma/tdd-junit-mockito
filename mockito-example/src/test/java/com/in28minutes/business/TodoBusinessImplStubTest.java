package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		
		TodoService todoServiceStub = new TodoServiceStub();
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredList = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredList.size());
		assertEquals("Learn Spring MVC", filteredList.get(0));
	}

}
