package com.example.todo.exception;

public class NotExistIdException extends RuntimeException {
    public NotExistIdException(String message) {
        super(message);
    }
}
