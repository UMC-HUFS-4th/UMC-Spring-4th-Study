package com.example.boardproject.controller;

import com.example.boardproject.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create/{boardId}")
    public ResponseEntity<String> createBoard(
            @PathVariable int boardId,
            @RequestParam String title,
            @RequestParam String content
    ) {
        String storedtitle = this.boardService.create(boardId, title, content);

        return ResponseEntity.ok().body(storedtitle);


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
