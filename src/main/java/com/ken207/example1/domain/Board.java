package com.ken207.example1.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private long id;

    private  String author;
    private  String subject;
    private  String content;
    private  LocalDateTime createdTime;
    private  LocalDateTime modifiedDate;
    private  int hitCount;
    private  boolean delYn;
    private  String password;

    @Builder.Default
    @OneToMany(mappedBy = "board")
    private List<Comments> commentsList = new ArrayList<>();

    public static Board postBoard(String author, String subject, String content,  String password){
       return Board.builder()
             .author(author)
             .subject(subject)
             .content(content)
             .hitCount(0)
             .createdTime(LocalDateTime.now())
             .modifiedDate(LocalDateTime.now())
             .delYn(false)
             .password(password)
             .build();
    }

    public int readBoard(){
        return this.hitCount++;
    }

    public void adjustBoard(String subject , String content){
        this.subject = subject;
        this.content = content;
        this.modifiedDate = LocalDateTime.now();
    }

    public void delete(){
        this.delYn = true;
    }
}
