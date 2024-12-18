package com.example.todo.dto;

import com.example.todo.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponseDto {

    // 속성
    private final Long id;
    private final String title;
    private final String contents;

    // 생성자
    public TodoResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    // Todo를 TodoResponseDto로 변환하는 정적 메서드
    public static TodoResponseDto todoResponseDto(Todo todo) {
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents());
    }
}
