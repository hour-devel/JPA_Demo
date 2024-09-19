package com.example.jpa_demo.controller;

import com.example.jpa_demo.entity.Product;
import com.example.jpa_demo.request.ProductRequest;
import com.example.jpa_demo.service.ProductService;
import com.example.jpa_demo.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/product")
@RestController
public class ProductController {
    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ApiResponse apiResponse = ApiResponse.builder()
                .code(200)
                .payload(products)
                .httpStatus(HttpStatus.OK)
                .massag("Get all Product successfully")
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .code(200)
                .payload(product)
                .httpStatus(HttpStatus.OK)
                .massag("Get Product by id successfully")
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.saveProduct(productRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .httpStatus(HttpStatus.OK)
                .payload(product)
                .code(200)
                .massag("product saved successfully")
                .build();
        return  ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
        Product product  = productService.updateProduct(id, productRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .httpStatus(HttpStatus.OK)
                .payload(product)
                .code(200)
                .massag("product updated successfully")
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id) {
        productService.deleteProduct(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .code(200)
                .httpStatus(HttpStatus.OK)
                .massag("product deleted successfully")
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
