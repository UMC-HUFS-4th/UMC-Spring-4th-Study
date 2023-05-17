package com.example.boardproject.service;


import com.example.boardproject.Entity.Board;
import com.example.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class BoardService {

    private final BoardRepository boardRepository;

    public String create(String title, String content) {
        Board board = Board.builder().title(title).content(content).build();
        boardRepository.save(board);

        return title;
    }

    public List<Board> get() {
        // JPA -> 메소드 명으로 가져올 수 았음
        return boardRepository.findAll();
    }

    public String update(Long id, String title, String content) {
        Optional<Board> board = boardRepository.findById(id);
        if(board.isEmpty()) {
            throw new RuntimeException(id+"에 해당하는 게시글이 존재하지 않습니다.");
        }

        Board foundBoard = board.get();

        foundBoard.setTitle(title);
        foundBoard.setContent(content);
        boardRepository.save(foundBoard);

        return foundBoard.getTitle();
    }

    public Board delete(Long Id) {
        Optional<Board> board = boardRepository.findById(Id);

        if(!board.isPresent()) {
            throw new RuntimeException(Id + "에 해당하는 게시글이 존재하지 않습니다");
        }

        Board foundBoard = board.get();
        boardRepository.delete(foundBoard);
        return foundBoard;
    }
}
