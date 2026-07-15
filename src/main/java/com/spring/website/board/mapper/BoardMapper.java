package com.spring.website.board.mapper;

import com.spring.website.board.dto.BoardDTO;
import com.spring.website.common.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    List<BoardDTO> boardList();

    int boardInsert(BoardDTO boardDTO);

    int readCntUpdate(@Param("boardNumber") int boardNumber);

    int boardDelete(int boardNumber);

    Optional<BoardDTO> boardDetail(@Param("boardNumber") int boardNumber);

    int boardUpdate(BoardDTO boardDTO);

    List<BoardDTO> selectBoardList(PageRequestDTO pageRequestDTO);

}
