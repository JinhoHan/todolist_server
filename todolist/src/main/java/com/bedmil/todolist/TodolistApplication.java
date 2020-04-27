package com.bedmil.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner runner(TodoRepository todoRepository) throws Exception {
//		return (args) -> {
//			IntStream.rangeClosed(1, 10).forEach(index -> todoRepository.save(Todo.builder()
//					.content("오늘 할 일" + index)
//					.createdDateTime(LocalDateTime.now())
//					.isComplete(false)
//					.build())
//			);
//		};
//	}
}