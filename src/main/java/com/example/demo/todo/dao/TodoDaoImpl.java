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
		return todoList;
	}

	@Override
	public void addTodo(int status, String todoName) {
		if(todoName != null && todoName != "") {
			String sql = "INSERT INTO TODO (STATUS, NAME) VALUES(?, ?)";
			jdbcTemplate.update(sql, status, todoName);
		} else {
			String sql = "INSERT INTO TODO (STATUS, NAME) VALUES(?, 'NewTask')";
			jdbcTemplate.update(sql, status);
		}
	}

	@Override
	public void deleteTodo(int id) {
		String sql = "DELETE FROM TODO WHERE ID = ?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public void updateTodo(int id,int status) {
		String sql = "UPDATE TODO SET STATUS = ? WHERE ID = ?";
		jdbcTemplate.update(sql,status,id);
	}

}
