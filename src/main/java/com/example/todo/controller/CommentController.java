package com.example.todo.controller;

import com.example.todo.dto.CommentResponseDto;
import com.example.todo.dto.UpdateCommentRequestDto;
import com.example.todo.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos/{todo_id}/comments")
public class CommentController {

    // 속성
    private final CommentService commentService;

    // 생성자

    // 기능
    @PostMapping
    public ResponseEntity<Void> createComment(
        @PathVariable("todo_id") Long feedId
    ) {
      return null;
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getComments(
        @PathVariable("todo_id") Long feedId
    ) {
      return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(
        @PathVariable("todo_id") Long todoId,
        @PathVariable("id") Long commentId,
        @RequestParam String password,
        @RequestBody UpdateCommentRequestDto request
    ) {
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(
        @PathVariable("todo_id") Long todoId,
        @PathVariable("id") Long commentId,
        @RequestParam String password
    ) {

      commentService.deleteComment(commentId, password);

      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

