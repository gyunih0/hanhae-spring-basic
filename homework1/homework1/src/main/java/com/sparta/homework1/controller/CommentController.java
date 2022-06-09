package com.sparta.homework1.controller;


import com.sparta.homework1.domain.Comment;
import com.sparta.homework1.domain.CommentDto;
import com.sparta.homework1.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/board/{boardId}/comment")
    public Long postComment(@PathVariable Long boardId, @RequestBody @Valid CommentDto commentDto) {
        return commentService.createComment(boardId, commentDto);
    }

    @GetMapping("/board/{boardId}/comment")
    public List<Comment> getComments(@PathVariable Long boardId) {
        return commentService.getComments(boardId);
    }

    @PutMapping("/board/comment/{commentId}")
    public Long updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto) {
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/board/comment/{commentId}")
    public Long deleteComment(@PathVariable Long commentId) {
        return commentService.delete(commentId);
    }
}
