package com.example.todo.Dto;


import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
public class BoardWithAgeResponseDto {


    // 생성자
    private final String title;

    private final String contents;

    private final int age;


    // 기능
    public BoardWithAgeResponseDto(String title, String contents, int age) {
        this.title = title;
        this.contents = contents;
        this.age = age;
    }

}
