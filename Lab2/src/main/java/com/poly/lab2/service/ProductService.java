package com.poly.lab2.service;

import com.poly.lab2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductService - Quản lý danh sách sản phẩm
 * Giải thích: Service lưu trữ và quản lý sản phẩm, hỗ trợ phân trang
 */
@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    // Khởi tạo một số sản phẩm mẫu
    public ProductService() {
        products.add(new Product("iPhone 15", 25000000.0));
        products.add(new Product("Samsung Galaxy S24", 22000000.0));
        products.add(new Product("MacBook Pro", 45000000.0));
        products.add(new Product("Dell XPS 13", 30000000.0));
        products.add(new Product("iPad Pro", 28000000.0));
        products.add(new Product("Surface Pro", 35000000.0));
        products.add(new Product("AirPods Pro", 6000000.0));
        products.add(new Product("Sony WH-1000XM5", 8000000.0));
        products.add(new Product("Canon EOS R5", 85000000.0));
        products.add(new Product("Nintendo Switch", 8500000.0));
        products.add(new Product("PlayStation 5", 15000000.0));
        products.add(new Product("Xbox Series X", 14000000.0));
        products.add(new Product("Apple Watch", 12000000.0));
        products.add(new Product("Samsung Watch", 8000000.0));
        products.add(new Product("Dyson V15", 18000000.0));
        products.add(new Product("Tesla Model 3", 1500000000.0));
        products.add(new Product("BMW X5", 2200000000.0));
        products.add(new Product("Mercedes C-Class", 1800000000.0));
        products.add(new Product("Rolex Submariner", 250000000.0));
        products.add(new Product("Louis Vuitton Bag", 45000000.0));
    }

    // Thêm sản phẩm mới
    public void addProduct(Product product) {
        products.add(product);
    }

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return products;
    }

    // Lấy sản phẩm theo trang
    public List<Product> getProductsByPage(int page, int size) {
        int start = page * size;
        int end = Math.min(start + size, products.size());

        if (start >= products.size()) {
            return new ArrayList<>();
        }

        return products.subList(start, end);
    }

    // Lấy tổng số trang
    public int getTotalPages(int size) {
        return (int) Math.ceil((double) products.size() / size);
    }

    // Lấy tổng số sản phẩm
    public int getTotalProducts() {
        return products.size();
    }
}
