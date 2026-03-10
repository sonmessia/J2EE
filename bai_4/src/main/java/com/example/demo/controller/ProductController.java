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

import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;
  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public String listProducts(Model model) {
    List<Product> products = productService.getAllProducts();
    model.addAttribute("products", products);
    return "products/product_list";
  }

  @GetMapping("/add")
  public String showAddForm(Model model) {
    model.addAttribute("product", new Product());
    model.addAttribute("categories", categoryService.getAllCategories());
    return "products/product_add";
  }

  @PostMapping("/add")
  public String addProduct(@ModelAttribute Product product) {
    productService.saveProduct(product);
    return "redirect:/products";
  }

  @PostMapping("/save")
  public String saveProduct(@ModelAttribute Product product) {
    productService.saveProduct(product);
    return "redirect:/products";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable int id, Model model) {
    Product product = productService.getProductById(id);
    if (product != null) {
      model.addAttribute("product", product);
      model.addAttribute("categories", categoryService.getAllCategories());
      return "products/product_add";
    }
    return "redirect:/products";
  }

  @PostMapping("/edit/{id}")
  public String editProduct(@PathVariable int id, @ModelAttribute Product product) {
    product.setId(id);
    productService.saveProduct(product);
    return "redirect:/products";
  }

  @GetMapping("/delete/{id}")
  public String deleteProduct(@PathVariable int id) {
    productService.deleteProductById(id);
    return "redirect:/products";
  }
}
