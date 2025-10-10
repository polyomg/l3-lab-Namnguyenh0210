package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * OkController - Bài 1: Xử lý các request khác nhau
 * Giải thích: OK1 dùng POST, OK2 dùng GET, OK3 dùng GET với parameter
 */
@Controller
public class OkController {

    // Hiển thị trang ok.html khi truy cập /ok
    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }

    // OK 1: Xử lý POST request tới /ctrl/ok
    @PostMapping("/ctrl/ok")
    public String m1(Model model) {
        model.addAttribute("method", "m1() - POST Request từ OK 1");
        return "ok";
    }

    // OK 2: Xử lý GET request tới /ctrl/ok
    @GetMapping("/ctrl/ok")
    public String m2(Model model) {
        model.addAttribute("method", "m2() - GET Request từ OK 2");
        return "ok";
    }

    // OK 3: Xử lý GET request tới /ctrl/ok với parameter x
    @GetMapping(value = "/ctrl/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("method", "m3() - GET Request với parameter x từ OK 3");
        return "ok";
    }
}
