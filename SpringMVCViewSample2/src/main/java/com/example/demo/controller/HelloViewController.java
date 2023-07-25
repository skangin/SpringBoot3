package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloViewController {
    @GetMapping("view")
    public String helloview(){
        return "hello";
    }
    @GetMapping("/view2")
    public String morningview(){
        return "morning";
    }
}
