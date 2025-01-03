package com.example.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @NotBlank(message = "이메일 형식으로 입력해야 합니다.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;
    @NotBlank(message="비밀번호는 필수 입력입니다.") //유효성 검증 안내 메세지
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "비밀번호는 숫자, 대문자, 소문자, 특수문자를 포함해야 합니다.")
    @Size(min=8, message = "비밀번호는 8자 이상입니다.")
    private String password;


    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
