package com.example.demo.todo.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.todo.dao.TodoDao;
import com.example.demo.todo.entity.Todo;

@ExtendWith(MockitoExtension.class)
@DisplayName("TodoServiceImplの単体テスト")
class TodoServiceImplUnitTest {

	
	@Mock
	private TodoDao dao;
	
	@InjectMocks
	private TodoServiceImpl todoServiceImpl;
	
	
	@Test
	@DisplayName("todo取得　０件の場合")
	void getTodosReturnEmptyList() {
		List<Todo> emptyTodoList = new ArrayList<Todo>();
		
		when(dao.getTodos()).thenReturn(emptyTodoList);
		
		todoServiceImpl.getTodos();
		verify(dao, times(1)).getTodos();
	}
	
	@Test
	@DisplayName("todo取得　データがある場合")
	void getTodosReturnList() {
		List<Todo> isTodoList = new ArrayList<Todo>();
		Todo todo = new Todo(0,0,"task");
		isTodoList.add(todo);
		
		when(dao.getTodos()).thenReturn(isTodoList);
		
		todoServiceImpl.getTodos();
		verify(dao, times(1)).getTodos();
	}

}
