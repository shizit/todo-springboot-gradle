package com.example.demo.todo.form;

import java.util.ArrayList;
import java.util.List;

public class TodoForm {

	private List<String> checkTodo = new ArrayList<>();

	public List<String> getCheckTodo() {
		return checkTodo;
	}

	public void setCheckTodo(List<String> checkTodo) {
		this.checkTodo = checkTodo;
	}

}
