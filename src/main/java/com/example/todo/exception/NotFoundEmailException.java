package com.example.todo.exception;

public class NotFoundEmailException extends RuntimeException {

    public NotFoundEmailException(String message) {
        super(message);
    }
}
