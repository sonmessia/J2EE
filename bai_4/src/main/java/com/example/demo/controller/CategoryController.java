package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CategoryService;
import com.example.demo.model.Category;

@Controller
@RequestMapping("/categories")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public String listCategories(Model model) {
    List<Category> categories = categoryService.getAllCategories();
    model.addAttribute("categories", categories);
    return "category_list";
  }

  @GetMapping("/add")
  public String showAddForm(Model model) {
    model.addAttribute("category", new Category());
    return "category_form";
  }

  @PostMapping("/add")
  public String addCategory(@ModelAttribute Category category) {
    categoryService.saveCategory(category);
    return "redirect:/categories";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable int id, Model model) {
    Category category = categoryService.getCategoryById(id);
    if (category != null) {
      model.addAttribute("category", category);
      return "category_form";
    }
    return "redirect:/categories";
  }

  // @PostMapping("/edit/{id}")
  // public String editCategory(@PathVariable int id, @ModelAttribute Category
  // category) {
  // category.setId(id);
  // categoryService.saveCategory(category);
  // return "redirect:/categories";
  // }
}
