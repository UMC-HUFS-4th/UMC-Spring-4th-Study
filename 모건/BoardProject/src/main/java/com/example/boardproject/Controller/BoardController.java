package com.example.boardproject.Controller;

import com.example.boardproject.entity.Board;
import com.example.boardproject.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/board") // http://localhost:8080/board
public class BoardController {

    private final BoardService boardService;

    //pathvariable 1개 와  queryString 2개
    @PostMapping("/create/")
    public ResponseEntity<String> createBoard(
            @RequestParam String title,
            @RequestParam String content
    ) {
        String storedTitle = this.boardService.create(title, content);
        return ResponseEntity.ok().body(storedTitle);
    }

    //ResponseEntity = Header, Body, HttpStatus
    @GetMapping("/get")
    public ResponseEntity<List<Board>> getBoard(
    ) {
        List<Board> boardList = this.boardService.get();
        return ResponseEntity.ok().body(boardList);
    }

    //수정된 게시글의 제목
    @PutMapping("/update/{Id}")
    public ResponseEntity<String> updateBoard(
            @PathVariable Long Id, //수정할 게시글의 id
            @RequestParam String title,
            @RequestParam String content //수정할 게시글의 제목과 내용
    ) {
        String updatedTitle = this.boardService.update(Id, title, content);
        return ResponseEntity.ok().body(updatedTitle);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Board> deleteBoard(
        @PathVariable Long Id
    ) {
        Board deletedBoard = this.boardService.delete(Id); //삭제 후, 삭제된 게시글 받고 리턴
        return ResponseEntity.ok().body(deletedBoard);
    }

//    @GetMapping("/get")
//    public List<Board> getBoard() {
//        log.info("정상적");
//        return this.boardList;
//    }
//
//    @PutMapping("/update/{boardId}")
//    public String updateBoard(
//            @PathVariable int boardId,
//            @RequestParam String title,
//            @RequestParam String content
//    ) {
//        for (int i = 0; i < this.boardList.size(); i++) {
//            if (boardList.get(i).getId() == boardId) {
//                boardList.get(i).setTitle(title);
//                boardList.get(i).setContent(content);
//                log.info("새로운 제목과 내용: " + title + "" + content);
//                return "정상 수정";
//            }
//        }
//        log.error("존재하지 않는 게시물입니다.");
//        throw new RuntimeException("비정상!");
//    }
//
//    @DeleteMapping("/delete/{boardId}")
//    public ResponseEntity<Board> deleteBoard( // 반환형으로 Board를 보내겠다.
//            @PathVariable int boardId
//    ) {
//        for (int i = 0; i < this.boardList.size(); i++) {
//            if (boardList.get(i).getId() == boardId) {
//                boardList.remove(i);
//                log.info("삭제완료");
//                return new ResponseEntity<Board>(this.boardList.get(i), HttpStatus.OK);
//            }
//        }
//        log.error("존재하지 않는 게시물입니다.");
//        throw new RuntimeException("비정상!");
//    }
    // @RequestBody: 객체로 요청할때 쓰이는 어노테이션(JSON)
    // @ResponseEntity: 객체로 응답할 때 쓰이는 어노테이션(JSON)
}
