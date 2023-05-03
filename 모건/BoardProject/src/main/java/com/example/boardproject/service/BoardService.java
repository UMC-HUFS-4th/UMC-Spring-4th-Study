package com.example.boardproject.service;

import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


//id, title, content - 요청
//title로 응답
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public String create(Long Id, String title, String content) {

        Board board = new Board(Id, title, content);
        boardRepository.save(board);

        return title;
    }
}
