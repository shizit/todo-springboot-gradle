package com.example.demo.todo.service;

import java.util.List;

import com.example.demo.todo.entity.Todo;

public interface TodoService {

	List<Todo> getTodos();
	
	void addTodo(int status, String todoName);
	
	void deleteTodo(int id);
	
	void updateTodo(int id, int status);
}
