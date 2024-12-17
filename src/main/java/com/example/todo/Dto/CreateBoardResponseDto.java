package com.example.todo.Dto;


import lombok.Getter;

@Getter
public class CreateBoardResponseDto {

    // 속성
    final private Long id;

    final private String title;

    final private String contents;

    // 생성자
    public CreateBoardResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
