package com.poly.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * RectangleController - Điều khiển tính diện tích & chu vi hình chữ nhật
 * Giải thích: Nhận dữ liệu từ form, tính toán và trả về kết quả
 */
@Controller
public class RectangleController {
    // Hiển thị form nhập chiều rộng, chiều dài
    @GetMapping("/rectangle/form")
    public String form() {
        return "rectangle";
    }

    // Xử lý tính toán diện tích & chu vi
    @PostMapping("/rectangle/calc")
    public String calc(@RequestParam("width") double width,
                       @RequestParam("height") double height,
                       Model model) {
        double area = width * height;
        double perimeter = 2 * (width + height);
        String result = String.format("Diện tích: %.2f, Chu vi: %.2f", area, perimeter);
        model.addAttribute("result", result);
        return "rectangle";
    }
}

