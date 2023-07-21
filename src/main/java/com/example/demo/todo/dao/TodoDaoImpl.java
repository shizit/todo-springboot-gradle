package com.example.demo.todo.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.TodoMapper;
import com.example.demo.todo.entity.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {

	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate  namedJdbcTemplate;
	private final TodoMapper todoMapper;
	
	@Autowired
	public TodoDaoImpl (
		JdbcTemplate jdbcTemplate, 
		NamedParameterJdbcTemplate namedJdbcTemplate, 
		TodoMapper todoMapper ){
		this.jdbcTemplate = jdbcTemplate;
		this.namedJdbcTemplate = namedJdbcTemplate;
		this.todoMapper = todoMapper;
	}
	
	@Override
	public List<Todo> getTodos() {
		return todoMapper.findAll();
	}

	@Override
	public void addTodo(int status, String todoName) {
		Todo todo = new Todo();
		todo.setStatus(status);
		todo.setName(todoName);
		todoMapper.insert(todo);
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
