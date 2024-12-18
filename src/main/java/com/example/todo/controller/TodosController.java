package com.example.todo.controller;

import com.example.todo.Dto.CreateTodoRequestDto;
import com.example.todo.Dto.CreateTodoResponseDto;
import com.example.todo.Dto.TodoResponseDto;
import com.example.todo.Dto.UpdateTodoRequestDto;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")  // 경로를 /Todos로 변경
@RequiredArgsConstructor // 반드시 값이 필요한 생성자를 자동으로 만들어주는(주입) 기능 (final, @NonNull )
public class TodosController {  // 클래스 이름을 TodoController에서 TodosController로 변경

    private final TodoService todoService;
    private final TodoRepository repository;

//    @Autowired
//    public TodosController(TodoService todoService ) {
//        this.todoService = todoService ;
//    }

    // 일정 생성
    @PostMapping
    public ResponseEntity<CreateTodoResponseDto> createTodo(@RequestBody CreateTodoRequestDto requestDto) {
        CreateTodoResponseDto createTodoResponseDto =
                todoService.createTodo(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );

        return new ResponseEntity<>(createTodoResponseDto, HttpStatus.CREATED);
    }

    // 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findTodoById(@PathVariable Long id) {
        TodoResponseDto todoResponseDto = todoService.findById(id);

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    // 모든 일정 조회
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAllTodos() {
        List<TodoResponseDto> todoResponseDtoList = todoService.findAll();

        return new ResponseEntity<>(todoResponseDtoList, HttpStatus.OK);
    }

    // 일정 업데이트 (예: 제목이나 내용 수정)
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateTodo(
            @PathVariable Long id,
            @RequestBody UpdateTodoRequestDto requestDto
    ) {
        todoService.updateTodo(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 일정 삭제
    @DeleteMapping("/{id}") //몇번째 아이디를 삭제할거냐?.. // {} 안에 있는 게 @PathVariable 로 들어온다
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        //todoRepository.delete(todoRepository.findByIdOrElseThrow(id));
        todoService.deleteTodo(id); //service => repository.delete(  repository.findById(id) ) :service 거칠 필요 없다
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
