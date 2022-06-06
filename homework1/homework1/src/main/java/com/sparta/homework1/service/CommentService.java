package com.sparta.homework1.service;

import com.sparta.homework1.domain.Board;
import com.sparta.homework1.domain.Comment;
import com.sparta.homework1.domain.CommentDto;
import com.sparta.homework1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Long createComment(Board board, CommentDto commentDto) {

        Comment comment = new Comment(board, commentDto);
        commentRepository.save(comment);

        return comment.getId();
    }

    public List<Comment> getComments(Board board) {
        return commentRepository.findAllByBoard(board);
    }

    public Long updateComment(Long id, CommentDto commentDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다.")
        );

        comment.update(commentDto);
        commentRepository.save(comment);
        return comment.getId();
    }

    public Long delete(Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
