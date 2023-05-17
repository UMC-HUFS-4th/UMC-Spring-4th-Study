package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Board;
import org.example.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
@RestController
@Getter
public class BoardController {

    // POST board/
    // GET board/
    // PUT board/
    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<String> createBoard(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content
    ) {
        String storedTitle = this.boardService.create(title, content); // 저장된 타이틀
        return ResponseEntity.ok().body(storedTitle);
    }

    // Board -> 여러개 List<Board>
    // ResponseEntity -> Header, Body, HttpStatus
    @GetMapping("/get")
    public ResponseEntity<List<Board>> getBoard() {
        List<Board> boardList = this.boardService.get();
        return ResponseEntity.ok().body(boardList);
    }

    // pathVariable -> boardId
    // requestParam -> 수정될 제목, 수정될 내용

    // 수정된 게시글의 제목
    @PutMapping("/update/{boardId}")
    public ResponseEntity<String> updateBoard(
            @PathVariable(name = "boardId") Long id,
            @RequestParam String title,
            @RequestParam String content
    ) {
        String updatedTitle = this.boardService.update(id,title,content);
        return ResponseEntity.ok().body(updatedTitle);
    }


    // 삭제된 board
    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Board> deleteBoard(
            @PathVariable(name = "boardId") Long id
    ) {
        Board deletedBoard = this.boardService.delete(id); // 삭제하고 삭제된 게시글
        return ResponseEntity.ok().body(deletedBoard); // 리턴
    }



//    @GetMapping("/get")
//    public ResponseEntity<List<Board>> getBoard(
//
//    ) {
//        List<Board> boardList = this.boardService.get();
//        return ResponseEntity.ok().body(boardList);
//    }
//
//    @DeleteMapping("/delete/{boardId}")
//    public ResponseEntity<Void> deleteBoard(
//            @PathVariable(name = "boardId") Long id
//    ) {
//        this.boardService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping("/update/{boardId}")
//    public ResponseEntity<Board> updateBoard(
//            @PathVariable(name = "boardId") Long id,
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "content") String content
//    ) {
//        Board updatedBoard = this.boardService.update(id,title,content);
//        return ResponseEntity.ok().body(updatedBoard);
//    }
//}
}