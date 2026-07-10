package com.spring.website.client.board.controller;

import com.spring.website.board.dto.BoardDTO;
import com.spring.website.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class ClientBoardController {
    private final BoardService boardService;

    @GetMapping("/boardList")
    public String boardList(Model model) {
        List<BoardDTO> boardList = boardService.boardList();
        model.addAttribute("boardList", boardList);
        return "client/board/boardList";
    }
}
