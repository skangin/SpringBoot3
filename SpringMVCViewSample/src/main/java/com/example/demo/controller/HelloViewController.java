package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //요청에 맞게 대응을 결정해주는 역할
@RequestMapping("hello") //hello 라는 주소로 요청받으면 이 클래스를 실행해
//@RequestMapping(value = ({ "hello" , "hellospring"}) - 복수형태
public class HelloViewController {
    @GetMapping("view2")//get 라는 주소로 요청받으면 이 클래스를 실행해
    //@GetMapping(value = ({ "view" , "viewspring"}) - 둘다 맵핑
    public String morningView(){
        return "morning";
    }

    @GetMapping("view")
    public String helloView(){
        return "hello";
    }
}
