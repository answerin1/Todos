package com.example.todo.Dto;


import com.example.todo.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    // 속성
    private final  Long id;

    private final String title;

    private final String contents;

    // 생성자

    public BoardResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public static BoardResponseDto toDto(Board board) {
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());
    }
}
