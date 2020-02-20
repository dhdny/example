package com.ken207.example1.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comments {
    @Id
    @GeneratedValue
    @Column(name = "comments_id")
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
