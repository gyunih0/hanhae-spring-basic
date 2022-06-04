package com.sparta.homework1.controller;

import com.sparta.homework1.domain.Board;
import com.sparta.homework1.domain.BoardDto;
import com.sparta.homework1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public List<Board> getBoards() {
        return boardService.findBoards();
    }

    @PostMapping("board")
    public String postBoards(@RequestBody BoardDto boardDto) {
        String boardTitle = boardService.createBoard(boardDto);
        return boardTitle;
    }
}
