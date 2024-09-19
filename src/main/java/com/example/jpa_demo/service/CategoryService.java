package com.example.jpa_demo.service;

import com.example.jpa_demo.entity.Category;
import com.example.jpa_demo.request.CategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> getAllCategory();
    public Optional<Category> findCategoryById(Integer id);
    public Category saveCategory(CategoryRequest categoryRequest);
    public Category updateCategory(Integer id, CategoryRequest categoryRequest);
    public void deleteCategory(Integer id);
}
