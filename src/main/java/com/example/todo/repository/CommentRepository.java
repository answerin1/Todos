package com.example.todo.repository;

import com.example.todo.entity.Comment;
import com.example.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


  public interface CommentRepository extends JpaRepository<Todo, Long> {
    Comment findByCommentId(Long commentId);
  }
