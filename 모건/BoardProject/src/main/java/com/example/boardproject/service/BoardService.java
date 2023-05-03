package com.example.boardproject.service;

import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//id, title, content - 요청
//title로 응답
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public String create(String title, String content) {

        Board board = Board.builder()
                        .title(title)
                                .content(content)
                                        .build();
        boardRepository.save(board);

        return title;
    }

    public List<Board> get() {
        //JPA가 메소드명으로도 가져올 수 있게함
        return boardRepository.findAll();
    }

    //id로 찾아야 되는데 없을 때를 대비해
    public String update(Long id, String title, String content) {
        // id(pk)에 해당한는 board 찾기
        //Optional을 사용.
        Optional<Board> board = boardRepository.findById(id);
        // Optional == null 이라면
        if (board.isEmpty()){
            //Throw 예외
            throw new RuntimeException("존재하지 않는 게시물입니다.");
        }
        //찾은 게시판
        Board foundBoard = board.get(); // get을 하면 Optional 사라짐
        //제목을 새로 설정
        foundBoard.setTitle(title);
        foundBoard.setContent(content);
        boardRepository.save(foundBoard);
        return foundBoard.getTitle();
    }

    public Board delete(Long id) {
        //id로 찾자
        Optional<Board> board = boardRepository.findById(id);
        if(!board.isPresent()){
            throw new RuntimeException("존재하지 않는 게시물입니다.");
        }

        Board foundBoard = board.get();
        boardRepository.delete(foundBoard);

        return foundBoard;
    }


}
