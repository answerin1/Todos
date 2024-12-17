package com.example.todo.Dto;


import lombok.Getter;

@Getter
public class CreateBoardRequestDto {

    // 속성
    private final String title;

    private final String contents;

    private final String username; // 강의상 어떤 회원이 작성했는지 알기 위해 넣었다.

    // 생성자
    public CreateBoardRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
