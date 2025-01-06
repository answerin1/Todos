package com.example.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class CommentResponseDto {


  private Long id;
  private String content;
  private String author;
  private String createdAt;
  private String updatedAt;
}

