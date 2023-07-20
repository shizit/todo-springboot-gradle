package com.example.demo.todo.form;

import java.util.ArrayList;
import java.util.List;

public class TodoForm {

	private List<Integer> checkTodo = new ArrayList<>();
	private String todoName;

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public List<Integer> getCheckTodo() {
		return checkTodo;
	}

	public void setCheckTodo(List<Integer> checkTodo) {
		this.checkTodo = checkTodo;
	}

}
