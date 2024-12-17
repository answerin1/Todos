package com.example.todo.Dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    public String username;
    public String password;

    public String email; //과제 시 수정

    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }




}
