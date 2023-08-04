package com.example.project3.controller;

import com.example.project3.entity.BoardEntity;
import com.example.project3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("board/list")
    public String boardList(Model model,
                            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                            @RequestParam(required = false, defaultValue = "") String searchKeyword){
        Page<BoardEntity> list = null;
        if(searchKeyword == null){
            list = boardService.boardList(pageable);
        }else{
            list = boardService.boardSearchList(searchKeyword, pageable);
        }

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = ((nowPage-1)/5)*5+1;
        int endPage = Math.min(((nowPage-1) / 5 + 1)*5, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "board";

    }
    @GetMapping("board/write")
    public String boardWrite(){
        return "write";
    }
    @PostMapping("/board/writeR")
    public String boardWriteR(BoardEntity boardEntity, Model model)throws Exception{
        boardService.write(boardEntity);
        model.addAttribute("message","글 작성이 완료되었습니다.");

        model.addAttribute("searchUrl","/board/list");
        return "writeMessage";
    }

    @GetMapping("/board/view")
    public String boardView(Model model,Long id){
        model.addAttribute("board",boardService.boardView(id));
        return  "view";
    }
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Long id, Model model){
        model.addAttribute("board",boardService.boardView(id));
        return "modify";
    }
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Long id, BoardEntity board, Model model)throws Exception{
        BoardEntity boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());
        boardService.write(boardTemp);
        model.addAttribute("message","글 수정이 완료되었습니다.");

        model.addAttribute("searchUrl","/board/list");

        return "writemessage";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Long id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }
}
