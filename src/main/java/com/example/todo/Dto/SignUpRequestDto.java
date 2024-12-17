package com.example.todo.Dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    public String username;
    public String password;

    public int age; //과제 시 수정

    public SignUpRequestDto(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }




}
