package com.example.project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class BoardController {
    @GetMapping("board")
    public String baordview(){
        return "board";
    }
}
