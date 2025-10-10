package com.poly.lab2.controller;

import com.poly.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

/**
 * ProductController2 - Bài 4: Sử dụng Model và @ModelAttribute
 * Giải thích: Model chia sẻ dữ liệu, @ModelAttribute tự động thêm vào tất cả view
 */
@Controller
public class ProductController2 {

    @GetMapping("/product2/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        // ?1: Chia sẻ sản phẩm qua Model
        model.addAttribute("product1", p);
        return "product/form2";
    }

    @PostMapping("/product2/save")
    public String save(@ModelAttribute("product2") Product p, Model model) {
        // Sản phẩm p sẽ tự động được thêm vào model với tên "product2"
        // Khởi tạo lại sản phẩm mặc định
        Product defaultProduct = new Product("iPhone 30", 5000.0);
        model.addAttribute("product1", defaultProduct);
        return "product/form2";
    }

    // ?3: @ModelAttribute method - tự động thêm vào tất cả view của controller này
    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(
            new Product("Product A", 100.0),
            new Product("Product B", 200.0)
        );
    }
}
