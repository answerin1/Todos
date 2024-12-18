package com.example.todo.controller;

import com.example.todo.dto.*;
import com.example.todo.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        UserResponseDto usersResponseDto = userService.findById(id);

        return new ResponseEntity<>(usersResponseDto, HttpStatus.OK);
    }

    // 유저 업데이트 (예: 유저명)
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUsersRequestDto UserRequestDto
    ) {
        userService.updateUser(id, UserRequestDto.getUsername());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request, HttpServletResponse response) {
        // 유저 서비스(userService)를 참조해서 로그인 기능을 사용. 반환하는 Id를 userId에 저장
        Long userId =  userService.login(loginRequestDto); // 매개변수에는 타입 말고 이름을 적어 주

        // 로그인 실패 (인증 실패...401 에러)
        if (userId == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이메일과 비밀번호가 일치하지 않습니다.");
        }
        // 로그인 성공 처리
        // 기본은 true
        HttpSession session = request.getSession();
        // 세션에 유저id 저장
        session.setAttribute("userId", userId);

        // 쿠키에 세션 추가
        // 쿠키 생성
        Cookie cookie = new Cookie("userId", session.getId()); //(쿠키의 이름, 세션에서 가져온 아이디) 저장!

        // 쿠키에 값 세팅 (expire 시간을 주지 않으면 세션쿠키가 됨, 브라우저 종료시 로그아웃)
        // Response Set-Cookie: userId=1 형태로 전달된다.
        response.addCookie(cookie); //응답 시 클라이언트가 관리하라고 쿠키를 던져
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

