package com.example.todo.dto;

import lombok.Getter;

@Getter

public class UserResponseDto {

    // 속성
    private final String username;

    private final String email;

    // 생성자
    public UserResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
