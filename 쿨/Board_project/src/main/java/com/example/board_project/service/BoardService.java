package com.example.board_project.service;

import com.example.board_project.entity.Board;
import com.example.board_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//로직 처리
//id, title, content -> 요청
//title -> 응답
@Service
@RequiredArgsConstructor
public class BoardService {

    //Controller -> Service -> Repository

    private final BoardRepository boardRepository; // 의존성

    public String create(Long boardId, String title, String content) {

        Board board = new Board(boardId, title, content); //새로운 객체 생성
        boardRepository.save(board); //저장 완료
        return title; //저장된 제목 리턴

    }
}
