package com.mypet.mungmoong.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mypet.mungmoong.board.dto.Board;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    /**
     * 게시글 목록
     * /board/list
     * model : boardList
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {
        log.info("[GET] - /board/list");

        // 데이터 요청
        List<Board> boardList = new ArrayList<>();
        boardList.add(new Board(1,"제목1", "작성자1", "내용1"));
        boardList.add(new Board(2,"제목2", "작성자2", "내용2"));
        boardList.add(new Board(3,"제목3", "작성자3", "내용3"));

        // 모델 등록
        model.addAttribute("boardList", boardList);

        // 뷰 페이지 지정
        return "/board/list";       // /board/list.html
    }

    /**
     * 게시글 조회
     * [GET]
     * /board/read?no=?
     * - model : board
     * @param model
     * @param no
     * @return
     */
    @GetMapping("/read")
    public String read(Model model, @RequestParam("no") int no) {
        log.info("[GET] - /board/read");

        // 데이터 요청
        Board board = new Board(no, "제목","김은식","내용");

        // 모델 등록
        model.addAttribute("board", board);

        // 뷰 페이지 지정
        return "/board/read";
    }


    /**
     * 게시글 수정
     * [GET]
     * /board/update?no=?
     * - model : board
     * @param model
     * @param no
     * @return
     */
    @GetMapping("/update")
    public String update(Model model, @RequestParam("no") int no) {
        log.info("[GET] - /board/update");

        // 데이터 요청
        Board board = new Board(no, "제목","김은식","내용");

        // 모델 등록
        model.addAttribute("board", board);

        // 뷰 페이지 지정
        return "/board/update";
    }
    
    /**
     * 게시글 등록 화면
     * @return
     */
    @GetMapping("/insert")
    public String insert() {
        log.info("[GET] - /board/insert");

        return "/board/insert";
    }
    


    /**
     * 게시글 등록 처리
     * @param board
     * @return
     */
    @PostMapping("/insert")
    public String insertPro(Board board) {
        log.info("[POST] - /board/insert");
        log.info(board.toString());

        int result = new Random().nextInt(2);  // 0 또는 1

        // 데이터 등록 실패
        if( result == 0 )
            return "redirect:/board/insert";

        return "redirect:/board/list";
    }


    /**
     * 게시글 수정 처리
     * @param board
     * @return
     */
    @PostMapping("/update")
    public String updatePro(Board board) {
        log.info("[POST] - /board/update");
        log.info(board.toString());

        int result = new Random().nextInt(2);  // 0 또는 1

        // 데이터 수정 실패
        if( result == 0 )
            return "redirect:/board/update?no=" + board.getNo();

        // 데이터 수정 성공
        return "redirect:/board/list";
    }

    /**
     * 게시글 삭제 처리
     * @param board
     * @return
     */
    @PostMapping("/delete")
    // public String deletePro(Board board) {
    public String deletePro(@RequestParam("no") int no) {
        log.info("[POST] - /board/delete");
        // int no = board.getNo();
        log.info(no + " 번 글을 삭제합니다." );

        int result = new Random().nextInt(2);

        if( result == 0 ) 
            return "redirect:/board/update?no=" + no; 
        
        return "redirect:/board/list";
    }
    
    
    // 게시글 수정 처리 - [PUT]
    @PutMapping("")
    public ResponseEntity<String> putUpdate(Board board) {
        log.info("[PUT] - /board");
        log.info(board.toString());
        
        // 게시글 수정 처리
        int result = new Random().nextInt(2);
        
        if( result == 0 )
            return new ResponseEntity<>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
    
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    // 게시글 삭제 처리 - [DELETE]
    @DeleteMapping("")
    public ResponseEntity<String> delete(@RequestParam("no") int no) {
        log.info("[DELETE] - /board?no=10");
        log.info(no + " 번 게시글 삭제합니다.");
        
        // 게시글 삭제 처리
        int result = new Random().nextInt(2);
        
        if( result == 0 )
            return new ResponseEntity<>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
    
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}







