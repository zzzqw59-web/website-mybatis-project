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
    public BoardDTO boardDetail(int boardNumber) {
        boardMapper.readCntUpdate(boardNumber);
        return boardMapper.boardDetail(boardNumber).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

    @Override
    public int boardDelete(int boardNumber) {
        return boardMapper.boardDelete(boardNumber);
    }

    @Override
    public BoardDTO updateForm(int boardNumber) {
        return boardMapper.boardDetail(boardNumber).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

    @Override
    public int boardUpdate(BoardDTO boardDTO) {
        int result = boardMapper.boardUpdate(boardDTO);
        if (result == 0) {
            throw new IllegalArgumentException("게시글 수정에 실패했습니다.");
        }
        return result;
    }
}
