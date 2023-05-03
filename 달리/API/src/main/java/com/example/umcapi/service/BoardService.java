package com.example.umcapi.service;

import com.example.umcapi.entity.Board;
import com.example.umcapi.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


// 로직을 처리
// id,title,content -> 요청
// title -> 응답
@Service
@RequiredArgsConstructor
public class BoardService {

    // boardController -> boardService -> boardRepository

    private final BoardRepository boardRepository;// BoardRepository 의존성 추가

    public String create(Long id, String title, String content) {

        Board board = new Board(id, title, content); // 새로운 객체 생성
        boardRepository.save(board); // 저장 완료

        return title; // 저장된 제목 리턴
    }


    public List<Board> get() {

        return boardRepository.findAll();
    }

    public String delete(Long id) {

        Board board = boardRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("해당하는 게시글이 존재하지 않습니다."));

        this.boardRepository.delete(board);

        return board.getTitle();
    }

    public Board update(Long id, String title, String content) {

        Board board = boardRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("해당하는 게시글이 존재하지 않습니다."));


        board.setTitle(title);
        board.setContent(title);

        return board;
    }
}