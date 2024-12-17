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

    private final UserRepository UserRepository;
    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String password, String email) {

        User member = new User(username, password, email);

        User savedMember = UserRepository.save(member);


        return new SignUpResponseDto(savedMember.getUsername(), savedMember.getEmail());
    }

    public UserResponseDto findById(Long id) {
        
        UserRepository.findById(id);
        
        if (UserRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id : " + id);
        }

       return new UserResponseDto(UserRepository.findByIdOrElseThrow(id).getUsername(), UserRepository.findByIdOrElseThrow(id).getEmail());
    }

    public void updateUser(Long Id, String username) {

        // String username -> 4단계 구현시 매개변수로 넣기!!

        User user = userRepository.findByIdOrElseThrow(Id);  // 해당 ID의 일정 찾기

        if (username == null) {
            username= user.getUsername();
        }

//        if (username== null) {
//            username = user.getUser().getUsername();
//        }

        user.updatedUsername(username);  // 일정의 제목과 내용을 업데이트
        userRepository.save(user);  // 변경된 내용 저장
    }

    @Transactional //묶어주는 기능(하나의 트렌젝션 내에서 동작하게 만들어준다)
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findMember = UserRepository.findByIdOrElseThrow(id);

        if (!findMember.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus .UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findMember.updatedPassword(newPassword);
    }
}
