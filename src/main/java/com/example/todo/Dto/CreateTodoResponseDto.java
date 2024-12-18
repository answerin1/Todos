package com.example.todo.Dto;

import lombok.Getter;

@Getter
public class CreateTodoResponseDto {

        // 속성
        final private Long id;

        final private String title;

        final private String contents;


        // 생성자
        public CreateTodoResponseDto(Long id, String title, String contents) {
            this.id = id;
            this.title = title;
            this.contents = contents;
        }
    }

