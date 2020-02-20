package com.ken207.example1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardReqDto {
    private String author;
    private String subject;
    private String content;
    private String password;
}