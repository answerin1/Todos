package com.example.todo.service;


import com.example.todo.Dto.BoardResponseDto;
import com.example.todo.Dto.BoardWithAgeResponseDto;
import com.example.todo.entity.Board;
import com.example.todo.entity.Member;
import com.example.todo.repository.BoardRepository;
import com.example.todo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public BoardResponseDto save(String title, String contents, String username) {

        memberRepository.findMemberByUsernameOrElseThrow(username);

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Board board = new Board(title, contents);
        board.setMember(findMember);

        Board savedBoard = boardRepository.save(board);

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }

    public List<BoardResponseDto> findAll() { //  게시글 조회

            return boardRepository.findAll()
                    .stream()
                    .map(BoardResponseDto::toDto)
                    .toList();
        }

    public BoardWithAgeResponseDto findById(Long id) {
        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        Member writer = findBoard.getMember();

        return new BoardWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), writer.getAge());
    }

    public void delete(Long id) {

            Board findBoard = boardRepository.findByIdOrElseThrow(id);

            boardRepository.delete(findBoard);
        }
    }
