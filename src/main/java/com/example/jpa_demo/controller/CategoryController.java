package com.example.jpa_demo.controller;

import com.example.jpa_demo.entity.Category;
import com.example.jpa_demo.request.CategoryRequest;
import com.example.jpa_demo.service.CategoryService;
import com.example.jpa_demo.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        List<Category> category = categoryService.getAllCategory();

        ApiResponse apiResponse = ApiResponse.builder()
                .code(200)
                .massag("Get All Category Successfully")
                .httpStatus(HttpStatus.OK)
                .payload(category)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        Optional<Category> category = categoryService.findCategoryById(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .payload(200)
                .httpStatus(HttpStatus.OK)
                .massag("Category Id Get Successfully")
                .payload(category)
                .build();
        return  ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryService.saveCategory(categoryRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .payload(category)
                .massag("Category Save Successfully")
                .code(201)
                .httpStatus(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateCategory(@PathVariable Integer id,@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryService.updateCategory(id, categoryRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .massag("Category Update Successfully")
                .code(201)
                .httpStatus(HttpStatus.OK)
                .payload(category)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        ApiResponse apiResponse = ApiResponse.builder()
                .httpStatus(HttpStatus.OK)
                .code(201)
                .massag("Category Delete Successfully")
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
