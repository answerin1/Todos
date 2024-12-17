package com.example.todo.service;

import com.example.todo.Dto.CreateTodoResponseDto;
import com.example.todo.Dto.TodoResponseDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    // 일정 생성
    public CreateTodoResponseDto createTodo(String title, String contents, String username) {
        // var user = userRepository.findMemberByUsernameOrElseThrow(username); // username으로 사용자 찾기 create에서는 필요 없다!!
        // 너 누구야 강사님,,? 강사 너어어어어어억 ㅠㅠㅠㅠㅠㅠ 나 울어 ㅠㅠㅠㅠㅠㅠㅠ -> 트슈다 트슈~!!!!! 두개나 건짐 ㄷㄷ
        // 착실하게 강의를 들은 증거 = 잘못... 너무 착실했다^^ 착실 그ㅡ 잡채요
        //ㅋㅋ 만 금조ㅋ덜 성자실하 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
        Todo todo = new Todo(title, contents, username);  // 새로운 Todos 생성
//        todo.setUsername(username);  // 해당 사용자와 연결

        Todo savedTodo = todoRepository.save(todo);  // 저장

        return new CreateTodoResponseDto(savedTodo.getTitle(), savedTodo.getContents(),savedTodo.getUsername());
    }

    // ID를 통한 조회
    public TodoResponseDto findById(Long id) {
        Todo todo = todoRepository.findByIdOrElseThrow(id);  // ID로 일정 조회
        return new TodoResponseDto(todo.getUsername(), todo.getTitle(), todo.getContents());
    }

    // 모든 일정 조회
    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(todo -> new TodoResponseDto(todo.getUsername(), todo.getTitle(), todo.getContents()))
                .collect(Collectors.toList());
    }

    // 일정 업데이트
    public void updateTodo(Long Id, String title, String contents) {

        Todo todo = todoRepository.findByIdOrElseThrow(Id);  // 해당 ID의 일정 찾기

        if (title == null) {
            title = todo.getTitle();
        }

        if (contents == null) {
            contents = todo.getContents();
        }

        todo.update(title, contents);  // 일정의 제목과 내용을 업데이트
        todoRepository.save(todo);  // 변경된 내용 저장
    }

    // 일정 삭제
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findByIdOrElseThrow(id);  // 해당 ID의 일정 찾기
        todoRepository.delete(todo);  // 일정 삭제
    }
}
