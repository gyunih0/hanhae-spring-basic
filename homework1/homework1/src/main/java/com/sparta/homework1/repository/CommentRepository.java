package com.sparta.homework1.repository;

import com.sparta.homework1.domain.Board;
import com.sparta.homework1.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoard(Board board);

}
