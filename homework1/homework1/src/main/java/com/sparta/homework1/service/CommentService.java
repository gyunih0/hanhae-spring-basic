package com.sparta.homework1.service;

import com.sparta.homework1.domain.Board;
import com.sparta.homework1.domain.Comment;
import com.sparta.homework1.domain.CommentDto;
import com.sparta.homework1.repository.BoardRepository;
import com.sparta.homework1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {


    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, BoardRepository boardRepository) {
        this.commentRepository = commentRepository;
        this.boardRepository = boardRepository;
    }

    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        );
    }



    public Long createComment(Long boardId, CommentDto commentDto) {
        Board board = findBoardById(boardId);
        Comment comment = new Comment(board, commentDto);
        commentRepository.save(comment);

        return comment.getId();
    }

    public List<Comment> getComments(Long boardId) {
        Board board = findBoardById(boardId);
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
