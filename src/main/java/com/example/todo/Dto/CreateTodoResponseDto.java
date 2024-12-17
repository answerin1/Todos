package com.example.todo.Dto;

import lombok.Getter;

@Getter
public class CreateTodoResponseDto {

        // 속성
        final private String title;

        final private String contents;

        final private String username;

        // 생성자
        public CreateTodoResponseDto(String title, String contents, String username) {
            this.title = title;
            this.contents = contents;
            this.username = username;
        }
    }

