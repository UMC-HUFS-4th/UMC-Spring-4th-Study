package com.example.boardproject.service;

import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 로직을 처리
// id, title, content --> request
// title로 반환 --> response
@RequiredArgsConstructor // RequiredArgConstructor은 꼭 초기화가 되어야하는 생성자를 만들어줌. final 사용할때 사용
//@Transactional
@Service
public class BoardService {
    // boardController -> boardService -> boardRepository
    private final BoardRepository boardRepository; // BoardRepository 의존성 추가
    public String create(long id, String title, String content) {
        Board board = new Board(id, title, content); // 새로운 객체 생성
        boardRepository.save(board); // 저장 완료

        return title; // 저장된 제목 return
    }

}
