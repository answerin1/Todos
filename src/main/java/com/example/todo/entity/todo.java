package com.example.todo.entity;

import jakarta.persistence.Entity;

@Entity
public class todo {

    private String id;
    private String username;
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;

    // 필드명이 동일하므로 @Column(name = "title"
}
