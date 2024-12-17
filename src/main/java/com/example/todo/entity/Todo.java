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


    private String title;
    private String contents;


    @ManyToOne // N(일정):1(유저)
    @JoinColumn(name = "user_id" , referencedColumnName = "id") //유저 테이블의 id를 참조하는 키가 유저아이디라고 todoTable에 생성됨
    private User user;

    // 기본 생성자
    public Todo() {

    }

    // 생성자
    public Todo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

//    private String createdAt; 이미 상속 받은 것이기에 중복해서 쓸 필요 없다!
//    private String updatedAt;

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;

    }







}
