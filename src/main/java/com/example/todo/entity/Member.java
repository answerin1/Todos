package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int age; // 강의상 age

    public Member() {}

    public Member(String username, String password, int age) {

        this.username = username;
        this.password = password;
        this.age = age;
        }

        public void updatedPassword(String password) {
            this.password = password;
        }

}

