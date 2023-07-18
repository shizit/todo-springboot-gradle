package com.example.demo.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.todo.entity.Todo;
import com.example.demo.todo.form.TodoForm;
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
	@RequestMapping(params="add", method=RequestMethod.POST)
	public String add(Model model) {
		service.addTodo();
		List<Todo> todoList = service.getTodos();	
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	
	@RequestMapping(params="delete", method=RequestMethod.POST)
	public String delete(Model model) {
		service.deleteTodo(7);
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);		
		return "todo/index";
	}
}
