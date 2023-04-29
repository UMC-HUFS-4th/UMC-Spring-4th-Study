package com.example.boardproject.service;


import com.example.boardproject.Entity.Board;
import com.example.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class BoardService {

    private final BoardRepository boardRepository;

    public String create(int id, String title, String content) {
        Board board = new Board(id, title, content);
        boardRepository.save(board);

        return title;
    }
}
