package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Jpa auditing 사용한 것임

public abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = false) // 생성시간이 수정되지 못하게 설정!
    @Temporal(TemporalType.TIMESTAMP) // 생략가능.. 날짜 타입을 세부적으로 지정하는 기능
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP) // 생략가능
    private LocalDateTime upDatedAt;
}


