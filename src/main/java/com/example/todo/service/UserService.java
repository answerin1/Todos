package com.example.todo.service;

import com.example.todo.Dto.UserResponseDto;
import com.example.todo.Dto.SignUpResponseDto;
import com.example.todo.entity.User;
import com.example.todo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository; // 필드 중복 제거

    // 회원 가입 메서드
    public SignUpResponseDto signUp(String username, String password, String email) {
        User member = new User(username, password, email);
        User savedMember = userRepository.save(member);
        return new SignUpResponseDto(savedMember.getUsername(), savedMember.getEmail());
    }

    // 사용자 ID로 조회
    public UserResponseDto findById(Long id) {
        // Optional로 유저를 찾고 없으면 예외 발생
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

        // 유저 정보 반환
        return new UserResponseDto(user.getUsername(), user.getEmail());
    }

    // 사용자 정보 업데이트
    public void updateUser(Long id, String username) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

        if (username == null) {
            username = user.getUsername(); // 입력된 사용자 이름이 없으면 기존 값 사용
        }

        user.updatedUsername(username);  // 사용자의 이름 업데이트
        userRepository.save(user);  // 변경 사항 저장
    }

    // 비밀번호 업데이트 (트랜잭션 적용)... 묶어주기
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

        // 기존 비밀번호 확인
        if (!user.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect old password.");
        }

        // 비밀번호 업데이트
        user.updatedPassword(newPassword);
    }

    // 사용자 삭제 메서드
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

        userRepository.delete(user);  // 유저 삭제
    }
}
