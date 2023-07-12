package com.example.demo.controller;

import com.example.demo.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("hello")
public class ThymeleafController {
    @GetMapping("a")
    public String showA(){
        return "pageA";
    }
    @GetMapping("show")
    public String ShowView(Model model){
        Member member = new Member(1,"희원01");



        //ArrayList, HashMap, List, Map

        Member member1 = new Member(10, "홍길동");
        Member member2 = new Member(20, "이영희");

        //list 생성
        List<String> directionList = new ArrayList();
        directionList.add("동");
        directionList.add("서");
        directionList.add("남");
        directionList.add("북");

        //map을 생성해서 member를 저장
        Map<String, Member> memberMap = new HashMap<>();

        memberMap.put("hong", member1);
        memberMap.put("lee", member2);

        //arraylist를 생성해서 member를 저장
        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);

        //Model에 데이터를 추가
        model.addAttribute("name","이순신");
        model.addAttribute("mb",member);
        model.addAttribute("list",directionList);
        model.addAttribute("map",memberMap);
        model.addAttribute("members",memberList);

        return "useThymeleaf";
    }
}
