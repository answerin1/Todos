package com.example.todo.Dto;

import lombok.Getter;

@Getter
public class UpdateTodoRequestDto {

    //속성
    private String title;
    private String contents;

    //생성자

    public UpdateTodoRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
