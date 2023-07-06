package com.fluc.demo.chapter02;

import org.springframework.stereotype.Component;

//인스턴스를 이용하고 싶은 곳에 어노테이션을 부여한다.
//@Component
public class MorningGreet implements Greet{
    @Override
    public void greeting() {
        System.out.println("-----------------");
        System.out.println("좋은 아침입니다.");
        System.out.println("-----------------");
    }
}
