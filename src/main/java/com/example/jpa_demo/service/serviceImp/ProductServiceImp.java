package com.example.jpa_demo.service.serviceImp;

import com.example.jpa_demo.entity.Category;
import com.example.jpa_demo.entity.Product;
import com.example.jpa_demo.exception.CustomNotfoundException;
import com.example.jpa_demo.repository.CategoryRepository;
import com.example.jpa_demo.repository.ProductRepository;
import com.example.jpa_demo.request.ProductRequest;
import com.example.jpa_demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        productRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Product id not found")
        );
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(ProductRequest productRequest) {
        Optional<Category> category = categoryRepository.findById(productRequest.getCategoryId());
        if (!category.isPresent()) {
            throw new CustomNotfoundException("Category id not found");
        }
        Product product = Product.builder()
                .name(productRequest.getName())
                .qty(productRequest.getQty())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        product.setCategory(category.get());
        return productRepository.save(product);
    }
    @Override
    public Product updateProduct(Integer id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(
                () ->  new CustomNotfoundException("Product id not found")
        );
        Optional<Category> category = categoryRepository.findById(productRequest.getCategoryId());
        product.setName(productRequest.getName());
        product.setQty(productRequest.getQty());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Integer id) {
        productRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Product id not found")
        );
        productRepository.deleteById(id);
        return null;
    }
}