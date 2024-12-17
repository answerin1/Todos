package com.example.todo.Dto;


import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private String username;
    private String email;
    private String age;

    public SignUpResponseDto(String username, String email, String age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public SignUpResponseDto(Long id, String username, int age) {
    }
}
