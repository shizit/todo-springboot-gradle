package com.example.demo.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.todo.constant.Status;
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
		model.addAttribute("todoForm",  new TodoForm());
		return "todo/index";
	}
	@PostMapping("/enterEmpty")
	public String test(Model model) {
		return "redirect:/";
	}

	@PostMapping("/addIncomplete")
	public String addIncomplete(Model model, TodoForm todoForm) {
		service.addTodo(Status.INCOMPLETE, todoForm.getTodoName());
		return "redirect:/";
	}
	@PostMapping("/addRunning")
	public String addRunning(Model model, TodoForm todoForm) {
		service.addTodo(Status.RUNNING, todoForm.getTodoName());
		return "redirect:/";
	}
	@PostMapping("/addCompleted")
	public String addCompleted(Model model, TodoForm todoForm) {
		service.addTodo(Status.COMPLETED, todoForm.getTodoName());
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String delete(Model model, TodoForm form, BindingResult result) {
		service.deleteTodo(form.getCheckTodo());
		return "redirect:/";
	}

	@PostMapping("/updateToIncomplete")
	public String updateToInComplete(Model model, TodoForm form, BindingResult result) {
		service.updateTodo(form.getCheckTodo(), Status.INCOMPLETE);
		return "redirect:/";
	}
	
	@PostMapping("/updateToRunning")
	public String updateToRunning(Model model, TodoForm form, BindingResult result) {
		service.updateTodo(form.getCheckTodo(), Status.RUNNING);
		return "redirect:/";
	}
	
	@PostMapping("/updateToCompleted")
	public String updateToCompleted(Model model, TodoForm form, BindingResult result) {
		service.updateTodo(form.getCheckTodo(), Status.COMPLETED);
		return "redirect:/";
	}
}
