package com.spring.website.mapper;

import com.spring.website.board.dto.BoardDTO;
import com.spring.website.board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

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
    public void boardUpdateTest() {
        BoardDTO board = new BoardDTO();
        board.setBoardNumber(213);
        board.setBoardName("지문인");
        board.setBoardTitle("오타 개쩌네");
        board.setBoardContent("오타 잘 보긴 해야할듯");
        board.setBoardPasswd("456");
        board.setBoardReadCnt(886);
        board.setBoardDate("20/12/20");

        int result = boardMapper.boardUpdate(board);

        log.info("수정된 행의 수: {}", result);
    }

    @Test
    public void boardDeleteTest() {
        int boardNumber = 123;
        int result = boardMapper.boardDelete(boardNumber);

        log.info("삭제된 행의 수: {}", result);
    }
}
