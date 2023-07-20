package com.example.demo.todo.dao;

import java.util.List;

import com.example.demo.todo.entity.Todo;

public interface TodoDao {

	List<Todo> getTodos();
	
	void addTodo(int status, String todoName);
	
	void deleteTodo(int id);
	
	void updateTodo(int id, int status);
}
