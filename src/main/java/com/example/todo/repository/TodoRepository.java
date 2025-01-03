package com.example.todo.repository;

import com.example.todo.entity.Todo;
import com.example.todo.exception.NotFoundTodoException;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {


    default Todo findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundTodoException("일정을 찾을 수 없습니다."));
    }
}

