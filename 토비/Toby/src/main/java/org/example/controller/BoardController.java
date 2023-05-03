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

    private final BoardService boardService;

    @PostMapping("/create/{boardId}")
    public ResponseEntity<String> createBoard(
            @PathVariable(name = "boardId") Long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content
    ) {
        String storedTitle = this.boardService.create(id, title, content); // 저장된 타이틀
        return ResponseEntity.ok().body(storedTitle);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Board>> getBoard(

    ) {
        List<Board> boardList = this.boardService.get();
        return ResponseEntity.ok().body(boardList);
    }

    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Void> deleteBoard(
            @PathVariable(name = "boardId") Long id
    ) {
        this.boardService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{boardId}")
    public ResponseEntity<Board> updateBoard(
            @PathVariable(name = "boardId") Long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content
    ) {
        Board updatedBoard = this.boardService.update(id,title,content);
        return ResponseEntity.ok().body(updatedBoard);
    }
}
