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
@RestController
@Getter
public class BoardController {

    private final BoardService boardService;

    // pathvariable 1 개 and queryString 2개
    @PostMapping("/board/create/{boardId}")
    public ResponseEntity<String> createBoard(
            @PathVariable(name = "boardId") Long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content
    ) {
        String storedTitle = this.boardService.create(id, title, content); // 저장된 타이틀

        return ResponseEntity.ok().body(storedTitle);
    }
}












//    @GetMapping("/board/get")
//    public List<Board> getBoard() {
//        log.info("게시글 개수는 " + boardList.size() + " 입니다."); // 로그
//        return this.boardList; // get
//    }

//    @PutMapping("/board/update/{boardId}")
//    public String updateBoard(
//            @PathVariable(name = "boardId") Long boardId,
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "content") String content
//    ) {
//        for (int i = 0; i < this.boardList.size(); i++) {
//            if (this.boardList.get(i).getId() == boardId) {
//                this.boardList.get(i).setTitle(title);
//                this.boardList.get(i).setContent(content); // 수정 완료
//
//                log.info(boardId + " 번의 게시글 수정 완료하였습니다.");
//                return boardId + " 번의 게시글 수정 완료하였습니다.";
//            }
//        }
//        log.error(boardId + " 번의 게시글 존재하지 않습니다.");
//        return boardId + " 번의 게시글 존재하지 않습니다.";
//    }
//
//    @DeleteMapping("/board/delete/{boardId}")
//    public String deleteBoard(
//            @PathVariable(name = "boardId") Long boardId
//    ) {
//        for (Board board : this.boardList) {
//
//            if (board.getId() == boardId) {
//                this.boardList.remove(board);
//
//                log.info(boardId + " 번의 게시글 삭제 완료하였습니다.");
//                return boardId + " 번의 게시글 삭제하였습니다.";
//            }
//        }
//        log.error(boardId + " 번의 게시글 존재하지 않습니다.");
//        return boardId + " 번의 게시글 존재하지 않습니다.";
//    }
//}
