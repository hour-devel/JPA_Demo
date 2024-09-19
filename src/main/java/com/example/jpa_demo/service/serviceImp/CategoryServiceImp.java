package com.example.jpa_demo.service.serviceImp;

import com.example.jpa_demo.entity.Category;
import com.example.jpa_demo.exception.CustomNotfoundException;
import com.example.jpa_demo.repository.CategoryRepository;
import com.example.jpa_demo.request.CategoryRequest;
import com.example.jpa_demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(Integer id) {
        categoryRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Category id not found")
        );
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Integer id, CategoryRequest categoryRequest) {
        Optional<Category> findById = categoryRepository.findById(id);
        if (findById == null){
            throw  new CustomNotfoundException("category id not found");
        }
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("category id not found")
        );
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Category id not found")
        );
        categoryRepository.deleteById(id);
    }
}
