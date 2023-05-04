package com.example.umcapi.controller;

import com.example.umcapi.entity.Board;
import com.example.umcapi.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/create")
    public ResponseEntity<String> createBoard(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content
    ) {
        String storedTitle = this.boardService.create(title, content); // 저장된 타이틀
        return ResponseEntity.ok().body(storedTitle);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Board>> getBoard(

    ) {
        List<Board> boardList = this.boardService.get();
        return ResponseEntity.ok().build();
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











