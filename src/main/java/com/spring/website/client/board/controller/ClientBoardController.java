package com.spring.website.client.board.controller;

import com.spring.website.board.dto.BoardDTO;
import com.spring.website.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class ClientBoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model) {
        List<BoardDTO> boardList = boardService.boardList();
        model.addAttribute("boardList", boardList);
        return "client/board/list";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("board", new BoardDTO());
        return "client/board/write";
    }

    @PostMapping("/write")
    public String boardInsert(BoardDTO boardDTO) {
        boardService.boardInsert(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/{boardNumber}")
    public String boardDetail(@PathVariable int boardNumber, Model model) {
        BoardDTO boardDTO = boardService.boardDetail(boardNumber);
        model.addAttribute("board", boardDTO);
        return "client/board/detail";
    }

    @GetMapping("/{boardNumber}/update")
    public String updateForm(@PathVariable int boardNumber, Model model) {
        BoardDTO boardDTO = boardService.updateForm(boardNumber);
        model.addAttribute("board", boardDTO);
        return "client/board/update";
    }

    @PostMapping("/update")
    public String boardUpdate(BoardDTO boardDTO) {
        boardService.boardUpdate(boardDTO);
        return "redirect:/board/" + boardDTO.getBoardNumber();
    }

    @PostMapping("/delete")
    public String boardDelete(int borderNumber) {
        boardService.boardDelete(borderNumber);
        return "redirect:/board/list";
    }
}
