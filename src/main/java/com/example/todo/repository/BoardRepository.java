package com.example.todo.repository;

import com.example.todo.entity.Board;
import com.example.todo.service.BoardService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long > {
    public default Board save(Board board) {
     return save(board);}

    default Board findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}
