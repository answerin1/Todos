package com.example.todo.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handlerNotFoundEmailException(NotFoundEmailException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handlerNotFoundUserException(NotFoundUserException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handlerNotExistIdException(NotExistIdException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse1 = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse1, HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handlerIncorrectPasswordException(IncorrectPasswordException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handlerNotFoundTodoException(NotFoundTodoException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class) //튜터님이 적어주신 예외 처리 코드... 참고!!!
    public ResponseEntity<ErrorResponse> handlerException(Exception e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}