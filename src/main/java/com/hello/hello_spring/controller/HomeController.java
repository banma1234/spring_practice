package com.hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 스프링 컨테이너 먼저 뒤지고 없으면 정적파일 뱉으니 임마 있으면 Home이 index 역할함.
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
