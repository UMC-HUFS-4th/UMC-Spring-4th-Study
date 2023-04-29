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
    @PostMapping("/create/{Id}")
    public ResponseEntity<String> createBoard(
            @PathVariable Long Id,
            @RequestParam String title,
            @RequestParam String content
    ) {
        String storedTitle = this.boardService.create(Id, title, content);

        return ResponseEntity.ok().body(storedTitle);
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
