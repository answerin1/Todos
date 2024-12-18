package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(updatable = false) // 생성시간이 수정되지 못하게 설정!
    @Temporal(TemporalType.TIMESTAMP) // 생략가능.. 날짜 타입을 세부적으로 지정하는 기능
    private LocalDateTime createdAt;

    public User() {}

    public User(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;
    }
    public void updatedPassword(String password) {
        this.password = password;
    }

    public void updatedUsername(String username) {
        this.username = username;
    }
}

