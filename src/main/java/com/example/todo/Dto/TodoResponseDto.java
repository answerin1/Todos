package com.example.todo.Dto;

import com.example.todo.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponseDto {

    // 속성
    private final String userName;
    private final String title;
    private final String contents;

    // 생성자
    public TodoResponseDto(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }

    // Todo를 TodoResponseDto로 변환하는 정적 메서드
    public static TodoResponseDto todoResponseDto(Todo todo) {
        return new TodoResponseDto(todo.getUsername(), todo.getTitle(), todo.getContents());
    }
}
