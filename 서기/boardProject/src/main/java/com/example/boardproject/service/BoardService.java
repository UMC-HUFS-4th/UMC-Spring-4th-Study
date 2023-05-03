package com.example.boardproject.service;

import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// 로직을 처리
// id, title, content --> request
// title로 반환 --> response
@RequiredArgsConstructor // RequiredArgConstructor은 꼭 초기화가 되어야하는 생성자를 만들어줌. final 사용할때 사용
//@Transactional
@Service
public class BoardService {
    // boardController -> boardService -> boardRepository
    private final BoardRepository boardRepository; // BoardRepository 의존성 추가
    public String create(String title, String content) {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();
        //Board board = new Board(id, title, content); // 새로운 객체 생성
        boardRepository.save(board); // 저장 완료

        return title; // 저장된 제목 return
    }

    public List<Board> get() {
        // JPA 관련 공부
        return boardRepository.findAll();
    }

    // id -> board
    @Transactional
    public String update(Long id, String title, String content) {
        // 1. id 에 해당하는 board 찾기
        // Optional null값 보호? (찾아보기)
        Optional<Board> board = boardRepository.findById(id);

        // Optional<Board> board -> null 인 경우
        // Throw로 예외처리
        if(board.isEmpty()){
            throw new RuntimeException(id + "에 해당하는 게시글이 존재하지 않습니다.");
        }

        // 조회한 게시판
        // .get을 하면 Optional 을 벗겨줌
        Board foundBoard = board.get();

        // title을 새로 설정
        foundBoard.setTitle(title);
        foundBoard.setContent(content);
        boardRepository.save(foundBoard);

        return foundBoard.getTitle();
    }


    public Board delete(Long id) {
        // 1. id에 해당하는 board 찾기
        Optional<Board> board = boardRepository.findById(id);

        // 위에 처럼 isEmpty() 와 같은 의미
        if(!board.isPresent()){
            throw new RuntimeException(id + "에 해당하는 게시글이 존재하지 않습니다.");
        }

        // 2. 삭제
        Board foundBoard = board.get();
        boardRepository.delete(foundBoard);
        return foundBoard;
    }
}
