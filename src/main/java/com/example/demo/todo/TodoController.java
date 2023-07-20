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
	@PostMapping("/updateTodoName")
	public String test(Model model) {
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		model.addAttribute("todoForm",  new TodoForm());
		return "todo/index";
	}
	
	@RequestMapping(params="updateTodoName", method=RequestMethod.POST)
	public String updateTodoName(Model model, TodoForm form, BindingResult result) {
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		model.addAttribute("todoForm",  new TodoForm());
		return "redirect:/";
	}

	@PostMapping("/addIncomplete")
	public String addIncomplete(Model model, TodoForm todoForm) {
		service.addTodo(Status.INCOMPLETE, todoForm.getTodoName());
		List<Todo> todoList = service.getTodos();	
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	@PostMapping("/addRunning")
	public String addRunning(Model model, TodoForm todoForm) {
		service.addTodo(Status.RUNNING, todoForm.getTodoName());
		List<Todo> todoList = service.getTodos();	
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	@PostMapping("/addCompleted")
	public String addCompleted(Model model, TodoForm todoForm) {
		service.addTodo(Status.COMPLETED, todoForm.getTodoName());
		List<Todo> todoList = service.getTodos();	
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String delete(Model model, TodoForm form, BindingResult result) {
		List<Integer> targetIds = form.getCheckTodo();
		for(Integer targetId: targetIds) {
			service.deleteTodo(targetId);
		}
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}

	@PostMapping("/updateToIncomplete")
	public String updateToInComplete(Model model, TodoForm form, BindingResult result) {
		List<Integer> targetIds = form.getCheckTodo();
		for(Integer targetId: targetIds) {
			service.updateTodo(targetId, Status.INCOMPLETE);
		}
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	
	@PostMapping("/updateToRunning")
	public String updateToRunning(Model model, TodoForm form, BindingResult result) {
		List<Integer> targetIds = form.getCheckTodo();
		for(Integer targetId: targetIds) {
			service.updateTodo(targetId, Status.RUNNING);
		}
		List<Todo> todoList = service.getTodos();
		model.addAttribute("todoList",todoList);
		return "redirect:/";
	}
	
	@PostMapping("/updateToCompleted")
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
