package com.study.board.controller;

import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"/blog"})
    public String index(Model model,
                        @PageableDefault(size=3, sort="id",
                                direction= Sort.Direction.DESC)
                        Pageable pageable) {
        model.addAttribute("boards", boardService.글목록(pageable));
        return "/board/blog";
    }

    @GetMapping("/blog/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/detail";
    }

    @GetMapping("/blog/{id}/updateForm")
    public String  updateForm(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/updateForm";
    }

    // USER 권한이 필요
    @GetMapping("/blog/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
