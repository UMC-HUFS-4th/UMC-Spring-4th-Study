package com.example.boardproject.controller;

import com.example.boardproject.Entity.Board;
import com.example.boardproject.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/board")
@RestController
@Getter
@AllArgsConstructor
public class BoardController {

//    @RequestMapping(method = "HttpMethod.POST")
    private final BoardService boardService;

    // Pathvatiable 1개
    // QueryString 2개

    @PostMapping("/create")
    public ResponseEntity<String> createBoard(
            @RequestParam String title,
            @RequestParam String content
    ) {
        String storedtitle = this.boardService.create(title, content);
        return ResponseEntity.ok().body(storedtitle);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Board>> getBoard() {
        List<Board> boardList = this.boardService.get();
        return ResponseEntity.ok().body(boardList);
    }

    @PutMapping("/update/{boardId}")
    public ResponseEntity<String> updateBoard(
            @PathVariable(name = "boardId") Long id,
            @RequestParam String title,
            @RequestParam String content
    ){
        String updateTitle = this.boardService.update(id,title,content);
        return ResponseEntity.ok().body(updateTitle);
    }
    // 삭제된 board
    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Board> deleteBoard(
            @PathVariable(name = "boardId") Long id
    ) {
        Board deleteBoard = this.boardService.delete(id);
        return ResponseEntity.ok().body(deleteBoard);
    }

    /*@GetMapping("/get")
    public List<Board> getBoard() {

    }

    @PutMapping("/update/{boardId}")
    public String updateBoard(
            @PathVariable(name = "boardId") int id,
            @RequestParam String title,
            @RequestParam String content
    ) {


    }

    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Board> deleteBoard( //반환형으로 Board를 보내겠다.
            @PathVariable int boardId
    )
*/
}

// @RequestBody -> 객체로 요청할때 쓰이는 어노테이션(Json)
// @ResponseEntity -> 객체로 응답할때 쓰이는 어노테이션(Json)
