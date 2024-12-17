package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email; // 강의상 age

    public User() {}

    public User(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;
    }
    public void updatedPassword(String password) {
        this.password = password;
    }

}

