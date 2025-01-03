package com.example.todo.exception;

public class NotFoundTodoException extends RuntimeException {
    public NotFoundTodoException(String message) {
        super(message);
    }
}
