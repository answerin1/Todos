package com.example.todo.Dto;


import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private String username;
    private String email;

    public SignUpResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }


}
