package com.example.boardproject.controller;

import com.example.boardproject.entity.Board;
import com.example.boardproject.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/board") // Http://localhost:8080/board
public class BoardController {

    private final BoardService boardService;

    //Path Variable 1개와 Query Parameter 2개
    // 컨트로럴는 응답을 받고 요청을 처리
    @PostMapping("/create")
    public ResponseEntity<String> createBoard(
            @RequestParam String title,
            @RequestParam String content)
        {
            String storedTitle = this.boardService.create(title, content); // 저장된 title을 반환
            return ResponseEntity.ok().body(storedTitle);
    }

    // Board는 여러개 -> List<Board>
    // ResponseEntity -> 응답에 대한 Header, Body, HttpStatus
    @GetMapping("/get")
    public ResponseEntity<List<Board>> getBoard(){
        List<Board> boardList = this.boardService.get();
        return ResponseEntity.ok().body(boardList);
    }

    // pathVariable -> boardId
    // requestParam -> 수정될 제목, 수정될 내용
    // 수정된 게시글의 제목을 return
    @PutMapping("/update/{boardId}")
    public ResponseEntity<String> updateBoard(
            @PathVariable(name = "boardId") Long id,
            @RequestParam String title,
            @RequestParam String content
    ){
        String updatedTitlte = this.boardService.update(id, title, content);
        return ResponseEntity.ok().body(updatedTitlte);
    }

    // 삭제된 board를 return
    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Board> deleteBoard(
            @PathVariable(name = "boardId") Long id
    ){
        Board deleteBoard = this.boardService.delete(id); // 삭제하고 삭제된 게시글
        return ResponseEntity.ok().body(deleteBoard); // 리턴
    }

//    @GetMapping("/get")
//    public List<Board> getBoard(){
//        log.info("정상적으로 get");
//        return this.boardList;
//    }
//
//    @PutMapping("/create/{boardId}")
//    public String updateBoard(
//            @PathVariable int boardId,
//            @RequestParam String title,
//            @RequestParam String content){
//        for (int i = 0; i < this.boardList.size(); i++) {
//            if (boardList.get(i).getId() == boardId) {
//                boardList.get(i).setTitle(title);
//                boardList.get(i).setContent(content);
//
//                log.info("새로운 제목과 내용 : " + title + " " + content);
//                return "정상적으로 수정완료되었습니다.";
//            }
//        }
//        log.error("요청한 게시글 아이디가 존재하지 않습니다.");
//        throw new RuntimeException("정상적으로 작동하지 않았습니다."); // 굳이 리턴 처리를 안하고 에외처리로 할 수 있음.
//
//    }
//
//
//    @DeleteMapping("/delete/{boardId}")
//    public ResponseEntity<Board> deleteBoard(@PathVariable int boardId){ // 반환형으로 Board를 보내겠다.
//
//        for (int i = 0; i < this.boardList.size(); i++) {
//            if (boardList.get(i).getId() == boardId) {
//                Board board = boardList.get(i); // 삭제될 Board 가 저장
//                boardList.remove(i);
//                return new ResponseEntity(board, HttpStatus.OK);
//                //log.info("게시판" + boardId + "의 정보가 삭제되엇습니다.");
//            }
//        }
//        log.error("요청한 게시글 아이디가 존재하지 않습니다.");
//        throw new RuntimeException("정상적으로 작동하지 않았습니다.");
//
//
//    }


    // @RequestBody -- > 객체로 요청할 떄 쓰이는 어노테이션(Json)
    // @ResponseEntity --> 객체로 응답할 때 쓰이는 어노테이션(Json)
}
