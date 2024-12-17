package com.example.todo.entity;

import jakarta.persistence.Entity;

@Entity
public class User {

    private String username;
    private String email;
    private String createdAt;
}
