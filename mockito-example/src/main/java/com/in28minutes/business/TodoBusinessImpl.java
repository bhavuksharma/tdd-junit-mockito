package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;

//TodoBusinessImpl SUT(system under test)
// TodoService Dependency
public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		
		List<String> filteredList = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		
		for(String todo: todos) {
			if(todo.contains("Spring")) {
				filteredList.add(todo);
			}
		}
		
		return filteredList;
	}
	
	public void deleteTodosNotRelatedToSpring(String user){
		
		List<String> todos = todoService.retrieveTodos(user);
		
		for(String todo: todos) {
			if(!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}
