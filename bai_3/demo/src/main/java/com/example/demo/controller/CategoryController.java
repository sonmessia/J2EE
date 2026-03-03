package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import jakarta.validation.Valid; // Updated for Spring Boot 3+
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("categories", categoryService.getAll());
    return "category/index";
  }

  @GetMapping("/add")
  public String add(Model model) {
    model.addAttribute("category", new Category());
    return "category/add";
  }

  @PostMapping("/add")
  public String add(@Valid @ModelAttribute("category") Category category,
      BindingResult result) {
    if (result.hasErrors()) {
      return "category/add";
    }
    categoryService.add(category);
    return "redirect:/categories";
  }
}
