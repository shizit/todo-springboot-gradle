package com.example.demo.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.todo.entity.Todo;
import com.example.demo.todo.form.TodoForm;
import com.example.demo.todo.service.TodoService;
import com.example.demo.todo.constant.Status;

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
		model.addAttribute("TodoForm",  new TodoForm());
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
	public String delete(Model model, TodoForm form, BindingResult result) {
		List<Integer> targetIds = form.getCheckTodo();
		for(Integer targetId: targetIds) {
			service.deleteTodo(targetId);
		}
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	
	@RequestMapping(params="updateToIncomplete", method=RequestMethod.POST)
	public String updateToInComplete(Model model, TodoForm form, BindingResult result) {
		List<Integer> targetIds = form.getCheckTodo();
		for(Integer targetId: targetIds) {
			service.updateTodo(targetId, Status.INCOMPLETE);
		}
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	
	@RequestMapping(params="updateToRunning", method=RequestMethod.POST)
	public String updateToRunning(Model model, TodoForm form, BindingResult result) {
		List<Integer> targetIds = form.getCheckTodo();
		for(Integer targetId: targetIds) {
			service.updateTodo(targetId, Status.RUNNING);
		}
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	
	@RequestMapping(params="updateToCompleted", method=RequestMethod.POST)
	public String updateToCompleted(Model model, TodoForm form, BindingResult result) {
		List<Integer> targetIds = form.getCheckTodo();
		for(Integer targetId: targetIds) {
			service.updateTodo(targetId, Status.COMPLETED);
		}
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
}
