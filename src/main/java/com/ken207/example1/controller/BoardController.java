package com.ken207.example1.controller;

import com.ken207.example1.domain.Board;
import com.ken207.example1.dto.BoardReqDto;
import com.ken207.example1.dto.BoardResDto;
import com.ken207.example1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sevice.BoardService;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;
    @GetMapping("/hello")
    public  String hello(){
        return "hello world";
    }

    @PostMapping("/hello")
    public BoardResDto postBoard(@RequestBody BoardReqDto boardReqDto){
        Long boardId = boardService.postBoard(boardReqDto);

      //  Optional<Board> boardOptional = boardRepository.findById(boardId);

      //  if (boardOptional.isPresent()) {
        //    Board board = boardOptional.get();
        //}

        Board board = boardRepository.findById(boardId).get();


        return BoardResDto.builder()
                .author(boardReqDto.getAuthor())
                .subject(boardReqDto.getSubject())
                .content(boardReqDto.getContent())
                .hitCount(0)
                .delYn(false)
                .createdTime(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();
    }


    @PutMapping("/update")
    public String adjustBoard(){
        return  "";
    }
    @PutMapping("/delete")
    public String deleteBoard(){
        return  "";
    }

}
