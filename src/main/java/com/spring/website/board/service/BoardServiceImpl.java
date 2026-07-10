package com.spring.website.board.service;

import com.spring.website.board.dto.BoardDTO;
import com.spring.website.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> boardList() {
        return boardMapper.boardList();
    }

    @Override
    public int boardInsert(BoardDTO boardDTO) {
        return boardMapper.boardInsert(boardDTO);
    }

    @Override
    public int boardUpdate(BoardDTO boardDTO) {
        return boardMapper.boardUpdate(boardDTO);
    }

    @Override
    public int boardDelete(int boardNumber) {
        return boardMapper.boardDelete(boardNumber);
    }
}
