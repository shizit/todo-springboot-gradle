package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.TodoMapper;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	private final TodoMapper todoMapper;
	
	public TodoApplication(TodoMapper todoMapper) {
		this.todoMapper = todoMapper;
	}
	
	public static void main(String[] args)  {
		SpringApplication.run(TodoApplication.class, args);
	}
	
	  @Override
	  public void run(String... args) throws Exception {
	    
	  }

}
