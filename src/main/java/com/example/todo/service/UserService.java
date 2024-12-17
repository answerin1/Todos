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

    private final UserRepository memberRepository;

    public SignUpResponseDto signUp(String username, String password, String email) {

        User member = new User(username, password, email);

        User savedMember = memberRepository.save(member);


        return new SignUpResponseDto(savedMember.getUsername(), savedMember.getEmail());
    }

    public UserResponseDto findById(Long id) {
        
        memberRepository.findById(id);
        
        if (memberRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id : " + id);
        }

       return new UserResponseDto(memberRepository.findByIdOrElseThrow(id).getUsername(), memberRepository.findByIdOrElseThrow(id).getEmail());
    }

    @Transactional //묶어주는 기능(하나의 트렌젝션 내에서 동작하게 만들어준다)
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findMember = memberRepository.findByIdOrElseThrow(id);

        if (!findMember.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus .UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findMember.updatedPassword(newPassword);
    }
}
