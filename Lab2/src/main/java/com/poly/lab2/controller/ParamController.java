package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ParamController - Bài 2: Thực hành @PathVariable và @RequestParam
 * Giải thích: x lấy từ URL path, y lấy từ form parameter
 */
@Controller
public class ParamController {

    // Hiển thị form
    @RequestMapping("/param/form")
    public String form() {
        return "form";
    }

    // Xử lý save với @PathVariable cho x và @RequestParam cho y
    @PostMapping("/param/save/{x}")
    public String save(@PathVariable String x, @RequestParam String y, Model model) {
        // Chia sẻ dữ liệu với view qua Model
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "form";
    }
}
