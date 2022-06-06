package com.sparta.homework1.controller;

import com.sparta.homework1.domain.Board;
import com.sparta.homework1.domain.BoardDto;
import com.sparta.homework1.domain.Comment;
import com.sparta.homework1.domain.CommentDto;
import com.sparta.homework1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/board")
    public String postBoard(@RequestBody BoardDto boardDto) {
        return boardService.createBoard(boardDto);
    }

    @PutMapping("/board/{id}")
    public Long updateBoard(@PathVariable long id, @RequestBody BoardDto boardDto) {
        return boardService.update(id, boardDto);
    }

    @DeleteMapping("/board/{id}")
    public Long deleteBoard(@PathVariable long id) {
        return boardService.delete(id);
    }
}
