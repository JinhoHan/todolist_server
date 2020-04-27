package com.bedmil.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bedmil.todolist.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}