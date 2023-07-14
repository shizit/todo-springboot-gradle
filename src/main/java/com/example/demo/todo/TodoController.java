package com.example.demo.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TodoController {

	public TodoController() {
	}
	
	@GetMapping
	public String index(Model model) {
		return "todo/index";
	}
}
