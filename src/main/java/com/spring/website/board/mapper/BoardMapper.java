package com.spring.website.board.mapper;

import com.spring.website.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> boardList();

    int boardInsert(BoardDTO boardDTO);

    int boardUpdate(BoardDTO boardDTO);

    int boardDelete(int boardNumber);
}
