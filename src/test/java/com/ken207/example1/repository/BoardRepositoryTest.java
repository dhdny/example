package com.ken207.example1.repository;

import com.ken207.example1.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    @Rollback(false)
    public void Board등록정상테스트(){
        //given
        Board requestData = Board.builder()
                .author("이경태")
                .content("내용")
                .createdTime(LocalDateTime.now())
                .subject("제목")
                .build();

        //builder 사용안할때
        //new Board("이경태", "내용", "제목",LocalDateTime.now());

        //when
        Board responseData = boardRepository.save(requestData);

        //then
        assertEquals("이경태",responseData.getAuthor());
        assertEquals(requestData.getContent(), responseData.getContent());
        assertEquals(requestData.getAuthor(), responseData.getAuthor());
        assertEquals(requestData.getCreatedTime(),responseData.getCreatedTime());
        assertEquals(requestData.getSubject(),responseData.getSubject());
        assertNotNull(responseData.getId());

    }
    @Test
    public  void BoardErrorTest(){
        Board requestData = Board.builder()
                .author("이경태")
                .content("내용")
                .createdTime(LocalDateTime.now())
                .subject("제목")
                .build();

        //builder 사용안할때
        //new Board("이경태", "내용", "제목",LocalDateTime.now());
        Board responseData = boardRepository.save(requestData);

        assertEquals("홍길동",responseData.getAuthor());
    }

    @Test
    public  void BoardUpdateTest(){
        //given
        Board requestData = Board.builder()
                .author("이경태")
                .content("내용")
                .createdTime(LocalDateTime.now())
                .subject("제목")
                .build();

        System.out.println("1 :: " + requestData.getClass());
        Board responseData = boardRepository.save(requestData);
        System.out.println("2 :: " + requestData.getClass());
        //when
        responseData.setAuthor("홍길동");
        System.out.println("3 :: " + requestData.getClass());
        Board selectBoard = boardRepository.findById(responseData.getId()).get();

        //then
        assertEquals("홍길동", selectBoard.getAuthor());
        //assertNotEquals(requestData.getAuthor(),selectBoard.getAuthor());
        assertEquals(responseData.getId(),selectBoard.getId());
    }
}