package com.example.demo.todo.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.todo.entity.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {

	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate  namedJdbcTemplate;
	@Autowired
	public TodoDaoImpl (JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedJdbcTemplate = namedJdbcTemplate;
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
	public void deleteTodo(List<Integer> ids) {
		String sql = "DELETE FROM TODO WHERE ID IN(:ids)";
		
		Set<Integer> idSet = new HashSet<>();
	    for(Integer i: ids) {
	    	idSet.add(i);
	    }
	    MapSqlParameterSource parameters = new MapSqlParameterSource();
	    parameters.addValue("ids", idSet);
		
	    namedJdbcTemplate.update(sql, parameters);
	}

	@Override
	public void updateTodo(int id,int status) {
		String sql = "UPDATE TODO SET STATUS = ? WHERE ID = ?";
		jdbcTemplate.update(sql,status,id);
	}

}
