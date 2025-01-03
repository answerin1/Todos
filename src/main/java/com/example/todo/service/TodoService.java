package com.example.todo.service;

import com.example.todo.dto.CreateTodoResponseDto;
import com.example.todo.dto.TodoResponseDto;
import com.example.todo.entity.Todo;
import com.example.todo.entity.User;
import com.example.todo.exception.NotFoundUserException;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    // 일정 생성
    public CreateTodoResponseDto createTodo(String title, String contents, String username, Long userId) {
        // userId로 사용자 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 새로운 Todo 생성 및 사용자 설정
        Todo todo = new Todo(title, contents);
        todo.assignUser(user);  // 사용자 설정

        Todo savedTodo = todoRepository.save(todo);  // 저장

        return new CreateTodoResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents());
    }

    // ID를 통한 조회
    public TodoResponseDto findById(Long id) {
        Todo todo = todoRepository.findByIdOrElseThrow(id);  // ID로 일정 조회
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents());
    }

    // 모든 일정 조회
    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(todo -> new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents()))
                .collect(Collectors.toList());
    }

    // 일정 업데이트
    public void updateTodo(Long id, String title, String contents) {
        Todo todo = todoRepository.findByIdOrElseThrow(id);  // 해당 ID의 일정 찾기

        // 일정의 제목과 내용을 업데이트 (null 체크는 엔티티 내부에서 처리)
        todo.update(title, contents);

        todoRepository.save(todo);  // 변경된 내용 저장
    }

    // 사용자 업데이트 (업데이트 로직이 추가된다고 가정하고 예시 작성)
    public void updateUser(Long userId, String newUsername) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundUserException("해당 사용자를 찾을 수 없습니다."));

        // 전달받은 값이 null이 아닐 때만 엔티티를 업데이트
        if (newUsername != null && !newUsername.isEmpty()) {
            user.setUsername(newUsername);
        }

        userRepository.save(user);  // 변경된 내용 저장
    }

    // 일정 삭제
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findByIdOrElseThrow(id);  // 해당 ID의 일정 찾기
        todoRepository.delete(todo);  // 일정 삭제
    }
}
