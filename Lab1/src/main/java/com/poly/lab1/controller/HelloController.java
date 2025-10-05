package com.poly.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HelloController - Điều khiển truy cập trang Hello World
 * Giải thích: Khi người dùng truy cập /poly/hello, phương thức hello() sẽ trả về hello.html
 */
@Controller
public class HelloController {
    @GetMapping("/poly/hello")
    public String hello() {
        // Trả về view hello.html
        return "hello";
    }
}

