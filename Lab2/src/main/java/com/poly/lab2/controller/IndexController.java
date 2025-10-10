package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController - Điều hướng trang chủ Lab2
 * Giải thích: Hiển thị trang index với danh sách các bài thực hành
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
