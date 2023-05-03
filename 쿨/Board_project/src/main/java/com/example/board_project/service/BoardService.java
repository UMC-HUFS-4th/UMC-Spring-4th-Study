package com.example.board_project.service;

import com.example.board_project.entity.Board;
import com.example.board_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//로직 처리
//id, title, content -> 요청
//title -> 응답
@Service
@RequiredArgsConstructor
public class BoardService {

    //Controller -> Service -> Repository

    private final BoardRepository boardRepository; // 의존성

    public String create(String title, String content) {

        Board board = Board.builder().title(title).content(content).build(); //새로운 객체 생성
        boardRepository.save(board); //저장 완료
        return title; //저장된 제목 리턴

    }

    public List<Board> get() {

        // JPA
        return boardRepository.findAll();
    }

    public String update(Long Id, String title, String content) {
        //1. 아이디에 해당하는 board 찾기
        Optional<Board> board = boardRepository.findById(Id);

        if(board.isEmpty()) {
            throw new RuntimeException(Id + "에 해당하는 게시글이 존재하지 않습니다");
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
