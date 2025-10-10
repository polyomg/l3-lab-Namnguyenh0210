package com.poly.lab2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product - Model cho bài 3 và 4
 * Giải thích: Sử dụng Lombok để tự động tạo getter, setter, constructor
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    String name;
    Double price;
}
