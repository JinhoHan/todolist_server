package com.bedmil.todolist;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.bedmil.todolist.domain.Todo;
import com.bedmil.todolist.repository.TodoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {

	private final String content = "내용";
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private Todo getSaved() {
		Todo todo = Todo.builder()
						.content(content)
						.createdDateTime(LocalDateTime.now())
						.build();
		
		return entityManager.persist(todo);
	}
	
	@Test
	public void test_get() {
		// GIVEN
		Todo todo = getSaved();
		System.out.println("=========================");
		System.out.println(todo.getId());
		System.out.println(todo.getContent());
		System.out.println(todo.getIsComplete());
		System.out.println(todo.getCreatedDateTime());
		System.out.println("=========================");
		Long id = todo.getId();
		
		// WHEN
		Todo savedTodo = todoRepository.getOne(id);
		
		// THEN
		assertThat(savedTodo.getContent()).isEqualTo(content);
		assertThat(savedTodo.getContent()).isEqualTo(todo.getContent());
	}
	
	@Test
	public void test_save() {
		// GIVEN
		Todo todo = Todo.builder()
						.content("내용1")
						.isComplete(true)
						.createdDateTime(LocalDateTime.now())
						.build();
		
		// WHEN
		Todo savedTodo = todoRepository.save(todo);
		System.out.println("=========================");
		System.out.println(savedTodo.getId());
		System.out.println(savedTodo.getContent());
		System.out.println(savedTodo.getIsComplete());
		System.out.println(savedTodo.getCreatedDateTime());
		System.out.println("=========================");
		
		// THEN
		assertThat(savedTodo.getId()).isGreaterThan(0);
		assertThat(savedTodo.getContent()).isEqualTo("내용1");
		assertThat(savedTodo.getIsComplete()).isEqualTo(true);
	}
	
	@Test
	public void test_delete() {
		// GIVEN
		Todo todo = getSaved();
		System.out.println("=========================");
		System.out.println(todo.getId());
		System.out.println(todo.getContent());
		System.out.println(todo.getIsComplete());
		System.out.println(todo.getCreatedDateTime());
		System.out.println("=========================");
		Long id = todo.getId();
		
		// WHEN
		todoRepository.deleteById(id);
		
		// THEN
		assertThat(entityManager.find(Todo.class, id)).isNull();
	}
}