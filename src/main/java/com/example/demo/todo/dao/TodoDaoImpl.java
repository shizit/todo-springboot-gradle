package com.example.demo.todo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.todo.entity.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public TodoDaoImpl (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Todo> getTodos() {
		String sql = "SELECT ID, STATUS, NAME FROM TODO";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Todo> todoList = new ArrayList<Todo>();
		for(Map<String, Object> result : resultList) {
			Todo todo = new Todo();
			todo.setId((int) result.get("ID"));
			todo.setStatus((int) result.get("STATUS"));
			todo.setName((String) result.get("NAME"));
			todoList.add(todo);
		}
		
//		Todo todo0 = new Todo(0, 0, "task0");
//		Todo todo1 = new Todo(1, 1, "task1");
//		Todo todo2 = new Todo(2, 2, "task2");
//		List <Todo> todoList = new ArrayList<Todo>();
//		todoList.add(todo0);
//		todoList.add(todo1);
//		todoList.add(todo2);
		
		return todoList;
	}

}
