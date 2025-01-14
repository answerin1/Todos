package com.example.todo.service;

import com.example.todo.config.PasswordEncoder;
import com.example.todo.dto.LoginRequestDto;
import com.example.todo.dto.UserResponseDto;
import com.example.todo.dto.SignUpResponseDto;
import com.example.todo.entity.User;
import com.example.todo.exception.IncorrectPasswordException;
import com.example.todo.exception.NotFoundUserException;
import com.example.todo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository; // 필드 중복 제거

    private final PasswordEncoder passwordEncoder;

    // 회원 가입 메서드
    public SignUpResponseDto signUp(String username, String password, String email) {
          String encodedPassword = passwordEncoder.encode(password);
        User member = new User(username, encodedPassword, email);
        User savedMember = userRepository.save(member);
        return new SignUpResponseDto(savedMember.getUsername(), savedMember.getEmail());
    }

    // 사용자 ID로 조회
    public UserResponseDto findById(Long id) {
        // Optional로 유저를 찾고 없으면 예외 발생
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        // 유저 정보 반환
        return new UserResponseDto(user.getUsername(), user.getEmail());
    }

    // 사용자 정보 업데이트
    public void updateUser(Long id, String username) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        if (username != null) {
            user.setUsername(username);
        }

        user.updatedUsername(username);  // 사용자의 이름 업데이트
        userRepository.save(user);  // 변경 사항 저장
    }

    // 비밀번호 업데이트 (트랜잭션 적용)... 묶어주기
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        // 기존 비밀번호 확인
        if (!user.getPassword().equals(oldPassword)) {
            throw new IncorrectPasswordException("비밀번호가 일치하지 않습니다.");
        }

        // 비밀번호 업데이트
        user.updatedPassword(newPassword);
    }

    // 사용자 삭제 메서드
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundUserException("사용자를 찾을 수 없습니다."));

        userRepository.delete(user);  // 유저 삭제
    }

    // 로그인 작동 -> 입력받은 이메일과 비밀번호로 유저 식별자를 받아온다
    public Long login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findIdByEmail(loginRequestDto.getEmail());

        boolean matches = passwordEncoder.matches(loginRequestDto.getPassword(),user.getPassword());
        if (!matches) {
            throw new IncorrectPasswordException("비밀번호가 일치하지 않습니다.");
        }

        return user.getId();
    }
}
