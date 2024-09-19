package com.example.jpa_demo.service;

import com.example.jpa_demo.entity.Product;
import com.example.jpa_demo.request.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Integer id);
    public Product saveProduct(ProductRequest productRequest);
    public Product updateProduct(Integer id, ProductRequest productRequest);
    public Product deleteProduct(Integer id);
}
