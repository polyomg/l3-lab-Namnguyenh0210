package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ResultController - Bài 5: Forward, Redirect và ResponseBody
 * Giải thích: Phân biệt các cách trả về kết quả khác nhau
 */
@Controller
public class ResultController {

    @RequestMapping("/a")
    public String m1() {
        return "a";
    }

    // ?1: Forward tới /a với Model - sử dụng "forward:"
    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a";  // Forward về /a, giữ nguyên Model
    }

    // ?2: Redirect tới /a với RedirectAttributes - sử dụng "redirect:"
    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";  // Redirect về /a, message thành parameter
    }

    // ?3: @ResponseBody - trả về trực tiếp String thay vì view
    @ResponseBody
    @RequestMapping("/d")
    public String m4() {
        return "I come from d";
    }
}
