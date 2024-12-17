package com.example.todo.Dto;


import lombok.Getter;

@Getter
public class CreateTodoRequestDto {

    // 속성
    private final String title;
    private final String contents;
    private final String username;

    // 생성자
    public CreateTodoRequestDto(String title,String contents, String username) {

        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}



