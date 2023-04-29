package com.example.boardproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/board") // Http://localhost:8080/board
public class BoardController {

    private List<Board> boardList = new ArrayList<>(); // 저장소

    //Path Variable 1개와 Query Parameter 2갸
    @PostMapping("create/{boardId}")
    public String createBoard(
            @PathVariable int boardId,
            @RequestParam String title,
            @RequestParam String content)
        {
            Board board = new Board(boardId, title, content);
            boardList.add(board);

            return "정상적으로 포스팅 되었습니다.";
    }

    @GetMapping("/get")
    public List<Board> getBoard(){
        log.info("정상적으로 get");
        return this.boardList;
    }

    @PutMapping("/create/{boardId}")
    public String updateBoard(
            @PathVariable int boardId,
            @RequestParam String title,
            @RequestParam String content){
        for (int i = 0; i < this.boardList.size(); i++) {
            if (boardList.get(i).getId() == boardId) {
                boardList.get(i).setTitle(title);
                boardList.get(i).setContent(content);

                log.info("새로운 제목과 내용 : " + title + " " + content);
                return "정상적으로 수정완료되었습니다.";
            }
        }
        log.error("요청한 게시글 아이디가 존재하지 않습니다.");
        throw new RuntimeException("정상적으로 작동하지 않았습니다."); // 굳이 리턴 처리를 안하고 에외처리로 할 수 있음.

    }


    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Board> deleteBoard(@PathVariable int boardId){ // 반환형으로 Board를 보내겠다.

        for (int i = 0; i < this.boardList.size(); i++) {
            if (boardList.get(i).getId() == boardId) {
                Board board = boardList.get(i); // 삭제될 Board 가 저장
                boardList.remove(i);
                return new ResponseEntity(board, HttpStatus.OK);
                //log.info("게시판" + boardId + "의 정보가 삭제되엇습니다.");
            }
        }
        log.error("요청한 게시글 아이디가 존재하지 않습니다.");
        throw new RuntimeException("정상적으로 작동하지 않았습니다.");


    }


    // @RequestBody -- > 객체로 요청할 떄 쓰이는 어노테이션(Json)
    // @ResponseEntity --> 객체로 응답할 때 쓰이는 어노테이션(Json)
}
