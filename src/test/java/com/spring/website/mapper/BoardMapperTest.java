package com.spring.website.mapper;

import com.spring.website.board.dto.BoardDTO;
import com.spring.website.board.mapper.BoardMapper;
import com.spring.website.common.dto.PageRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.Optional;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void boardListTest() {
        boardMapper.boardList().forEach(board -> {
            log.info(board.toString());
        });
    }

    @Test
    public void boardInsert() {
        BoardDTO board = new BoardDTO();
        board.setBoardName("이현이");
        board.setBoardTitle("이거 하기 싫다.");
        board.setBoardContent("CRUD 노잼");
        board.setBoardPasswd("456");
        board.setBoardReadCnt(156);
        board.setBoardDate("26/07/02");

        int result = boardMapper.boardInsert(board);

        log.info("등록된 행의 수: {}", result);
    }


    @Test
    public void boardDeleteTest() {
        int boardNumber = 123;
        int result = boardMapper.boardDelete(boardNumber);

        log.info("삭제된 행의 수: {}", result);
    }

    @Test
    public void readCntUpdateTest() {
        int boardNumber = 1;
        int count = boardMapper.readCntUpdate(boardNumber);
        log.info("수정된 행의 수: {}", count);
    }

    @Test
    public void boardDetailTest() {
        int boardNumber = 1;
        boardMapper.readCntUpdate(boardNumber);
        Optional<BoardDTO> optionalBoard = boardMapper.boardDetail(boardNumber);
        log.info("데이터 존재 여부: {} ", optionalBoard.isPresent());
        optionalBoard.ifPresent(boardDTO -> log.info("데이터 조회: {}", boardDTO));
    }

    @Test
    public void boardUpdateTest() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardTitle("미안하다 사랑한다");
        boardDTO.setBoardContent("ㅋㅋㅋ");
        boardDTO.setBoardPasswd("142");
        boardDTO.setBoardNumber(1);

        int result = boardMapper.boardUpdate(boardDTO);

        log.info("변경된 행의 수: {}", result);
    }

    @Test
    public void selectBoardListTest() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setSearchType("name");
        pageRequestDTO.setKeyword("홍");
        boardMapper.selectBoardList(pageRequestDTO).forEach(boardDTO -> {
            log.info(boardDTO.toString());
        });
    }
}
