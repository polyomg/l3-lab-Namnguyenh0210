package com.poly.lab2.controller;

import com.poly.lab2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ProductListController - Bài 6: Danh sách sản phẩm có phân trang
 * Giải thích: Hiển thị danh sách sản phẩm với phân trang, liên kết từ bài 3
 */
@Controller
public class ProductListController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String productList(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "5") int size,
                             Model model) {

        // Lấy danh sách sản phẩm theo trang
        var products = productService.getProductsByPage(page, size);
        var totalPages = productService.getTotalPages(size);
        var totalProducts = productService.getTotalProducts();

        // Chia sẻ dữ liệu với view
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);
        model.addAttribute("totalProducts", totalProducts);

        // Tính toán các trang hiển thị (tối đa 5 trang)
        int startPage = Math.max(0, page - 2);
        int endPage = Math.min(totalPages - 1, page + 2);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "product/list";
    }
}
