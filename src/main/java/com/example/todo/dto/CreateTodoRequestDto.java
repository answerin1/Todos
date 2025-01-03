package com.example.todo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateTodoRequestDto {

    // 속성
    @NotBlank(message = "제목은 필수입력값 입니다.")
    @Size(max=20, message = "20글자 내로 생성 가능합니다.")
    private final String title;
    @NotNull
    private final String contents;
    @NotNull
    private final String username;

    // 생성자
    public CreateTodoRequestDto(String title,String contents, String username) {

        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}



