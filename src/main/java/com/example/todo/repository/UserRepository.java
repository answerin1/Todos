package com.example.todo.repository;

import com.example.todo.entity.User;
import com.example.todo.exception.NotExistIdException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username); //ts

    User findIdByEmailAndPassword(String email, String password);
    // SELETE * FROM User u WHERE u.email = email AND u.password = password;

    default User findUserByUsernameOrElseThrow(String username) {
        return findUserByUsername(username)
                .orElseThrow(() -> new NotExistIdException(
                        "아이디가 존재하지 않습니다."));
    }


    default User findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new NotExistIdException(
                                "아이디가 존재하지 않습니다."));

    }
}

