package com.example.todo.service;

import com.example.todo.config.PasswordEncoder;
import com.example.todo.dto.CommentRequestDto;
import com.example.todo.dto.CommentResponseDto;
import com.example.todo.dto.UpdateCommentRequestDto;
import com.example.todo.entity.Comment;
import com.example.todo.exception.IncorrectPasswordException;
import com.example.todo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CommentService {

  // 속성
  private final CommentRepository commentRepository;
  private final PasswordEncoder passwordEncoder;


  // 생성자

  // 기능
  // 1. 댓글 수정 기능

  // 2. 댓글 삭제 가능


