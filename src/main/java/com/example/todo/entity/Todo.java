package com.example.todo.entity;

import jakarta.persistence.*;

@Table(name="TodoDevelop")
@Entity
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String username;
    private String title;
    private String description;

//    private String createdAt; 이미 상속 받은 것이기에 중복해서 쓸 필요 없다!
//    private String updatedAt;

    // 필드명이 동일하므로 @Column(name = "title")




}
