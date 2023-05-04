package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Board;
import org.example.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// 로직을 처리
// id,title,content -> 요청
// title -> 응답
@Service
@RequiredArgsConstructor
public class BoardService {

    // boardController -> boardService -> boardRepository

    private final BoardRepository boardRepository;// BoardRepository 의존성 추가

    public String create(String title, String content) {

        Board board = Board.builder()
                           .title(title)
                           .content(content)
                           .build();

        boardRepository.save(board); // 저장 완료

        return title; // 저장된 제목 리턴
    }

    public List<Board> get() {
        // JPA
        return boardRepository.findAll();
    }

    // id -> board
    public String update(Long id, String title, String content) {
        // 1. id(pk) 에 해당하는 board
        // Optional
        Optional<Board> board = boardRepository.findById(id);

        // if Optional<Board> board -> null
        if (board.isEmpty()) {
            // Throw -> 예외처리
            throw new RuntimeException(id + "에 해당하는 게시글이 존재하지 않습니다.");
        }

        // 조회한 게시판
        Board foundBoard = board.get();

        // title을 새로 설정
        foundBoard.setTitle(title);
        // content 새로 설정
        foundBoard.setContent(content);
        boardRepository.save(foundBoard);
        return foundBoard.getTitle();
    }

    public Board delete(Long id) {

        // 1. id 를 찾자
        Optional<Board> board = boardRepository.findById(id);

        if (!board.isPresent()) {
            throw new RuntimeException(id + "에 해당하는 게시글이 존재하지 않습니다.");
        }

        Board foundBoard = board.get();
        // 2. 삭제
        boardRepository.delete(foundBoard);

        return foundBoard;
    }


//    public List<Board> get() {
//
//        return boardRepository.findAll();
//    }
//
//    public String delete(Long id) {
//
//        Board board = boardRepository.findById(id)
//                                     .orElseThrow(() -> new RuntimeException("해당하는 게시글이 존재하지 않습니다."));
//
//        this.boardRepository.delete(board);
//
//        return board.getTitle();
//    }
//
//    public Board update(Long id, String title, String content) {
//
//        Board board = boardRepository.findById(id)
//                                     .orElseThrow(() -> new RuntimeException("해당하는 게시글이 존재하지 않습니다."));
//
//
//        board.setTitle(title);
//        board.setContent(title);
//
//        return board;
//    }
}