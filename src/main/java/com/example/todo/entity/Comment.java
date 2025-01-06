package com.example.todo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import javax.swing.JPasswordField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_id;

  @Column(nullable = false, unique = true)
  private String todo_id;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String email;

  @CreatedDate
  @Column(updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime createdAt;

  public Comment(String todo_id, String password, String email) {
  }

  public Comment() {

    this.todo_id = todo_id;
    this.password = password;
    this.email = email;
  }

  public void updatedPassword(String password) {
    this.password = password;
  }

  public void updated_todo_id(String todo_id) {
    this.todo_id = todo_id;
  }
}

