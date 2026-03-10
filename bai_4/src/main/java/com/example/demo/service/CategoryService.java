package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CategoryRepository;
import com.example.demo.model.Category;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public void saveCategory(Category category) {
    categoryRepository.save(category);
  }

  public Category getCategoryById(int id) {
    return categoryRepository.findById(id).orElse(null);
  }

  public void deleteCategoryById(int id) {
    categoryRepository.deleteById(id);
  }
}
