package com.sparta.homework1.controller;


import com.sparta.homework1.domain.Board;
import com.sparta.homework1.domain.Comment;
import com.sparta.homework1.domain.CommentDto;
import com.sparta.homework1.repository.BoardRepository;
import com.sparta.homework1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;
    private final BoardRepository boardRepository;

    @Autowired
    public CommentController(CommentService commentService, BoardRepository boardRepository) {
        this.commentService = commentService;
        this.boardRepository = boardRepository;
    }


//    @PostMapping("/")

    @PostMapping("/board/{id}/comment")
    public Long postComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        );

        return commentService.createComment(board, commentDto);
    }

    @GetMapping("/board/{id}/comment")
    public List<Comment> getComments(@PathVariable Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        );

        return commentService.getComments(board);
    }

    @PutMapping("/board/{id}/comment/{commentId}")
    public Long updateComment(@PathVariable Long id, @PathVariable Long commentId, @RequestBody CommentDto commentDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        );
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/board/{id}/comment/{commentId}")
    public Long deleteComment(@PathVariable Long id, @PathVariable Long commentId) {
        return commentService.delete(commentId);
    }
}
