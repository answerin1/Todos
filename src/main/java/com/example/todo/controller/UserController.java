package com.example.todo.controller;

import com.example.todo.Dto.UserResponseDto;
import com.example.todo.Dto.SignUpRequestDto;
import com.example.todo.Dto.SignUpResponseDto;
import com.example.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup") // 유저 생성
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // 유저 선택 조회
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto membersResponseDto = userService.findById(id);

        return new ResponseEntity<>(membersResponseDto, HttpStatus.OK);
    }
}