package com.example.demo.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.todo.dao.TodoDao;
import com.example.demo.todo.entity.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	private final TodoDao dao;
	
	@Autowired
	TodoServiceImpl(TodoDao dao){
		this.dao = dao;
	}

	@Override
	public List<Todo> getTodos() {
		
		return dao.getTodos();
	}

	@Override
	public void addTodo(int status, String todoName) {
		dao.addTodo(status, todoName);
		
	}

	@Override
	public void deleteTodo(int id) {
		dao.deleteTodo(id);
	}

	@Override
	public void updateTodo(int id, int status) {
		dao.updateTodo(id, status);
	}
	
}
