package com.example.boardproject.service;

import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
// 서비스 : 로직을 처리
// id, title, content 으로 요청하면
// 클라이언트에게 title 제목으로 반환(응답)

@Service
@RequiredArgsConstructor    // 꼭 초기화가 되어야 하는 생성자를 만들어줌 (AllArgs -- 해도 되지만 의존성 있는 객체라서)
public class BoardService {

    // boardController -> boardService -> boardRepository

    private final BoardRepository boardRepository;
    public String create(Long id, String title, String content) {

        Board board = new Board(id, title, content); // 새로운 객체 생성

        boardRepository.save(board); // 저장 완료

        return title; // 저장된 제목 리턴
    }
}
