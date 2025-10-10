package com.poly.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Bai3Controller - Điều khiển truy cập bài 3
 * Giải thích: Hiển thị trang chờ bổ sung cho bài 3
 */
@Controller
public class Bai3Controller {
    @GetMapping("/bai3")
    public String bai3() {
        return "bai3";
    }
}

