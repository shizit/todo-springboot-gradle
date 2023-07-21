package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.todo.entity.Todo;

@Mapper
public interface TodoMapper {
	
    @Select("SELECT id, name, status FROM todo")
    List<Todo> findAll();
    
    @Insert("INSERT INTO todo (status, name) VALUES (#{status}, #{name})")
    void insert(Todo todo);

}
