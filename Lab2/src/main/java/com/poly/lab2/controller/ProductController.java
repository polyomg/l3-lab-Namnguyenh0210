package com.poly.lab2.controller;

import com.poly.lab2.model.Product;
import com.poly.lab2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ProductController - Bài 3: Object binding với Product
 * Giải thích: Sử dụng Product object để nhận dữ liệu từ form, sau đó chuyển sang danh sách
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/form")
    public String form() {
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        // Thêm sản phẩm vào service
        productService.addProduct(product);

        // Thông báo thành công
        redirectAttributes.addFlashAttribute("message",
            "Đã thêm sản phẩm '" + product.getName() + "' thành công!");

        // Chuyển hướng sang danh sách sản phẩm
        return "redirect:/products";
    }
}
