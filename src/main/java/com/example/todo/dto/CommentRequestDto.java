package com.example.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class CommentRequestDto {

  @NotBlank(message = "내용은 빈칸이 불가합니다.")
  @Size(max = 100, message = "100자 이내로 작성이 가능합니다.")
  private String content;
}