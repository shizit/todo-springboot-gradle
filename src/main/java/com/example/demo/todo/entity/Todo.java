package com.example.demo.todo.entity;

public class Todo {
	
	private int id;
	private int status;
	private String name;
	
	public int getId() {
		return id;
	}
	public Todo() {
	}
	
	public Todo(int id, int status, String name) {
		this.id = id;
		this.status = status;
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
