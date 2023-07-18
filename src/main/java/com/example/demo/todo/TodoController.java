package com.example.demo.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.todo.entity.Todo;
import com.example.demo.todo.service.TodoService;

@Controller
@RequestMapping("/")
public class TodoController {

	private final TodoService service;
	
	@Autowired
	public TodoController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		
		return "todo/index";
	}
}
