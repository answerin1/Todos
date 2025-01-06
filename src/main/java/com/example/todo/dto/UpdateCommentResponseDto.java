package com.example.todo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCommentResponseDto {

  // 속성
  private Long id;
  private String content;
  private String author;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;



  // 생성자

  // 기능
}

