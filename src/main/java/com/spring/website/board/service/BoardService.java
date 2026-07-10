package com.spring.website.board.service;

import com.spring.website.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> boardList();

    int boardInsert(BoardDTO boardDTO);

    int boardUpdate(BoardDTO boardDTO);

    int boardDelete(int boardNumber);
}
