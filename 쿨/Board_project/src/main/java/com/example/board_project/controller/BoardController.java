package com.example.board_project.controller;

import com.example.board_project.entity.Board;
import com.example.board_project.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board") //http://localhost::8080/board
@RestController
@Slf4j
@Getter
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //PathVariable 1개
    //QueryString 2개
    @PostMapping("/create")
    public ResponseEntity<String> createBoard(
            @RequestParam String title,
            @RequestParam String content
    ) {
        String storedTitle = this.boardService.create(title, content); //리턴
        return ResponseEntity.ok().body(storedTitle);
    }

    //Board -> 여러개 List<Board>
    //ResponseEntity -> Header, Body HttpStatus
    @GetMapping("/get")
    public ResponseEntity<List<Board>> getBoard() {
        List<Board> boardList = this.boardService.get();
        return ResponseEntity.ok().body(boardList);
    }

    //pathVariable -> boardId
    // requestParam -> 수정될 제목, 수정될 내용
    //수정된 게시글의 제목
    @PutMapping("/update/{boardId}")
    public ResponseEntity<String> updateBoard(
        @PathVariable(name = "boardId") Long Id,
        @RequestParam String title,
        @RequestParam String content
    ) {
        String updateTitle = this.boardService.update(Id, title, content);
        return ResponseEntity.ok().body(updateTitle);
    }
    //삭제된 board
    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Board> deleteBoard(
            @PathVariable(name = "boardId") Long Id
    ) {
        Board deleteBoard = this.boardService.delete(Id);
        return ResponseEntity.ok().body(deleteBoard);
    }
}


//
//    @GetMapping("/get")
//    public List<Board> getBoard() {
//        log.info("정상적으로 get 되었습니다.");
//        return this.boardList;
//    }
//
//    @PutMapping("/update/{boardId}")
//    public String updateBoard(
//            @PathVariable int boardId,
//            @RequestParam String title,
//            @RequestParam String content
//    ) {
//        for(int i = 0; i < this.boardList.size(); i++){
//
//            if(boardList.get(i).getId() == boardId){
//                boardList.get(i).setTitle(title);
//                boardList.get(i).setContent(content);
//
//                log.info("새로운 재목과 내용 :");
//                return "정상적으로 수정완료되었습니다.";
//            }
//        }
//
//        log.error("요청한 게시글 아이디가 존재하지 않습니다.");
//        throw new RuntimeException("정상적으로 삭제되어지지 않았습니다.");
//    }
//
//    @DeleteMapping("/delete/{boardId}")
//    public ResponseEntity<Board> deleteBoard( //반환형으로 Board를 보내겠다.
//            @PathVariable int boardId
//    ){
//        for(int i = 0; i < this.boardList.size(); i++){
//            if(boardList.get(i).getId() == boardId){
//                Board board = boardList.get(i); //삭제될 Board가 저장
//                this.boardList.remove(boardList.get(i)); //List 삭제
//                return new ResponseEntity<>(board, HttpStatus.OK); //삭제한 board 리턴
//            }
//        }
//        log.error("요청한 게시글 아이디가 존재하지 않습니다.");
//        throw new RuntimeException("정상적으로 삭제되어지지 않았습니다.");
//        //컨트롤 + B로 확인
//
//    }
//
//    // @RequestBody -> 객체로 요청할 때 쓰이는 어노테이션(Json)
//    // @ResponseEntity -> 객체로 응답할 때 쓰이는 어노테이션(Json)
//
// }