package com.poly.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * AuthController - Điều khiển đăng nhập
 * Giải thích: Xử lý form đăng nhập, kiểm tra thông tin và trả về thông báo
 */
@Controller
public class AuthController {
    // Hiển thị form đăng nhập
    @GetMapping("/login/form")
    public String form() {
        return "login";
    }

    // Xử lý đăng nhập
    @PostMapping("/login/check")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // Kiểm tra thông tin đăng nhập
        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Đăng nhập thất bại. Vui lòng thử lại!");
        }
        return "login";
    }
}
