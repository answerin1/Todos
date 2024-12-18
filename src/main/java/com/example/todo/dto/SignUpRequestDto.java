package com.example.todo.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    public String username;
    public String password;
    public String email;

    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }




}
