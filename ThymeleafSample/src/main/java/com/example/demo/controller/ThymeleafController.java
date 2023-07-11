package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ThymeleafController {
    @GetMapping("show")
    public String ShowView(Model model){
        model.addAttribute("name", "이순신");

        return "useThymeleaf";
    }
}
