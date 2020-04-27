package com.bedmil.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.bedmil.todolist.domain.Todo;

public interface TodoService {

	List<Todo> getTodos(Sort sort) throws Exception;
	
	void postTodo(Todo todo) throws Exception;
	
	void deleteTodo(Long id) throws Exception;
	
	Todo findTodoById(Long Id) throws Exception;
}