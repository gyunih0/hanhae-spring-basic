package com.sparta.homework1.service;


import com.sparta.homework1.domain.Board;
import com.sparta.homework1.domain.BoardDto;
import com.sparta.homework1.domain.Comment;
import com.sparta.homework1.repository.BoardRepository;
import com.sparta.homework1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;


    @Autowired
    public BoardService(BoardRepository boardRepository, CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }


    public String createBoard(BoardDto boardDto) {

        Board board = boardRepository.save(new Board(boardDto));
        return board.getTitle();
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Long update(Long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        );

        board.update(boardDto);
        boardRepository.save(board);
        return board.getId();
    }

    public Long delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        );

        List<Comment> commentList = commentRepository.findAllByBoard(board);
        commentRepository.deleteAll(commentList);
        boardRepository.deleteById(id);

        return id;
    }



}
