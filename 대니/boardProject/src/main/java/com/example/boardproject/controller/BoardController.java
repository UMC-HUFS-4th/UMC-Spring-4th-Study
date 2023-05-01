package com.example.boardproject.controller;

import com.example.boardproject.entity.Board;
import com.example.boardproject.service.BoardService;
import com.example.boardproject.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@Slf4j
@RequestMapping("/board") // http://localhost:8080/board -> 로 들어오는 요청 받아줌
@RestController
public class BoardController {

    private final BoardService boardService;

    // Pathvariable 1개, query
    @PostMapping("/create/{id}") // http:localhost:8080/board/create/:boardId?
    public ResponseEntity<String> createBoard(
            @PathVariable Long id,  // 경로 변수
            @RequestParam String title, // 쿼리 스트링
            @RequestParam String content // 쿼리스트링

    ) {
        String storeTitle = this.boardService.create((long) id, title, content);

        return ResponseEntity.ok().body(storeTitle);
    }

//    @GetMapping("/get")
//    public List<Board> getBoard() {
//        log.info("정상적으로 get 되었습니다.");
//        return this.boardList;
//    }
//
//    @PutMapping("/update/{boardId}")
//    public String updateBoard(
//            @PathVariable(name = "boardId") int id,
//            @RequestParam String title, // 수정하고자 하는 제목
//            @RequestParam String content    // 수정하고자 하는 내용
//    ) {
//
//        for (int i = 0; i < this.boardList.size(); i++) {
//
//            if (boardList.get(i).getId() == id) {
//                boardList.get(i).setTitle(title);
//                boardList.get(i).setContent(content);
//                log.info("새로운 제목과 내용 : " + title + "" + content);
//                return ("정상적으로 수정완료되었습니다.");
//            }
//
//        }
//        log.error("요청한 게시글 아이디가 존재하지 않습니다.");
//        throw new RuntimeException("정상적으로 수정되지 않았습니다.");
//
//    }
//
//    @DeleteMapping("/delete/{boardId}")
//    public ResponseEntity<Board> deleteBoard(   // 반환형으로 Board를 보내겠다
//            @PathVariable int boardId) {
//
//        for (int i = 0; i < this.boardList.size(); i++) {
//            if (boardList.get(i).getId() == boardId) {
//                Board board = boardList.get(i);                          // 삭제될 Board가 저장됨
//                this.boardList.remove(boardList.get(i));                 // list 삭제
//                return new ResponseEntity<>(board, HttpStatus.OK);       // 삭제한 Board 를 Json 형태로 반환
//            }
//        }
//        log.error("요청한 게시글 아이디가 존재하지 않습니다.");
//        throw new RuntimeException("정상적으로 삭제되어지지 않았습니다.");
//
//        // RuntimeException 도 클래스 -> 클래스 원형을 보려면 컨트롤 누르고 보면 됨
//    }

    // @RequestBody -> 객체로 요청할 때 쓰이는 어노테이션(Json)
    // @ResponseEntity -? 객체로 응답할 때 쓰이는 어노테이션(Json)
}


