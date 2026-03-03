package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
  private List<Category> listCategory = new ArrayList<>();

  public CategoryService() {
    // Initializing with some dummy data for testing
    listCategory.add(new Category(1, "Electronics"));
    listCategory.add(new Category(2, "Fashion"));
    listCategory.add(new Category(3, "Home & Garden"));
  }

  public List<Category> getAll() {
    return listCategory;
  }

  public Category get(int id) {
    return listCategory.stream()
        .filter(c -> c.getId() == id)
        .findFirst()
        .orElse(null);
  }

  public void add(Category category) {
    listCategory.add(category);
  }
}
