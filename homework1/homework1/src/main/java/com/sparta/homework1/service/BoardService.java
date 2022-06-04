package com.sparta.homework1.service;


import com.sparta.homework1.domain.Board;
import com.sparta.homework1.domain.BoardDto;
import com.sparta.homework1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public String createBoard(BoardDto boardDto) {

        Board board = boardRepository.save(new Board(boardDto));
        System.out.println("board = " + board.getCreatedAt());
        return board.getTitle();
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

}
