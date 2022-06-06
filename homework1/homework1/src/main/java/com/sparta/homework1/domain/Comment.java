package com.sparta.homework1.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID", nullable = false)
    @JsonBackReference
    private Board board;

    @Column(nullable = false)
    private String name;

    @Column
    private String comments;

    public Comment(Board board, CommentDto commentDto) {
        this.board = board;
        this.name = commentDto.getName();
        this.comments = commentDto.getComments();
    }

    public void update(CommentDto commentDto) {
        this.name = commentDto.getName();
        this.comments = commentDto.getComments();
    }

    public void setBoard(Board board) {
        if (this.board != null) {
            this.board.getCommentList().remove(this);
        }
        this.board = board;
        if (!board.getCommentList().contains(this)) {
            board.addComment(this);
        }
    }

}
