package com.example.todo.Dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private Long id;

    public LoginResponseDto(Long id) {
        this.id = id;
    }
}
