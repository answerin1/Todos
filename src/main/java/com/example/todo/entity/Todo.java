package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table(name="TodoDevelop")
@Entity
public class Todo extends BaseEntity { // Base Entity 상속.. 셍성 및 수정 시간을 자동으로 생성 가능

    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String username;

    private String title;
    private String contents;

    // 기본 생성자
    public Todo() {

    }

    // 생성자
    public Todo(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

//    private String createdAt; 이미 상속 받은 것이기에 중복해서 쓸 필요 없다!
//    private String updatedAt;

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;

    }







}
