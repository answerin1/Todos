package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 기본 생성자 (JPA에서 사용)
    protected Todo() {
    }

    // 사용자 정의 생성자
    public Todo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    // 사용자 설정 메서드
    public void assignUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("사용자는 null일 수 없습니다.");
        }
        this.user = user;
    }

    // 일정 정보 업데이트 메서드
    public void update(String title, String contents) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (contents != null && !contents.isEmpty()) {
            this.contents = contents;
        }
    }
}
