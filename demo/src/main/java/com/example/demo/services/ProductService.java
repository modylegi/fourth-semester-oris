package com.example.demo.services;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();

    ProductDto createProduct(Product product);

    void deleteProduct(Long productId);

    ProductDto updateProduct(Long productId, String name, String description, int price);
}
