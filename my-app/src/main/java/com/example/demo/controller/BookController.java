package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
  @Autowired
  private BookService bookService;

  @GetMapping
  public String listBooks(final Model model) {
    model.addAttribute("books", bookService.getAllBooks());
    return "books/books";
  }

  @GetMapping("/add")
  public String addBookForm(final Model model) {
    model.addAttribute("book", new Book());
    return "books/add-book";
  }

  @PostMapping("/add")
  public String addBook(@ModelAttribute final Book book) {
    bookService.addBook(book);
    return "redirect:/books";
  }

  @GetMapping("/edit/{id}")
  public String editBookForm(@PathVariable("id") final Long id, final Model model) {
    bookService.getBookById(id).ifPresent(book -> model.addAttribute("book", book));
    return "books/edit-book";
  }

  @PostMapping("/edit")
  public String editBook(@ModelAttribute final Book book) {
    bookService.updateBook(book.getId(), book);
    return "redirect:/books";
  }

  @GetMapping("/delete/{id}")
  public String deleteBook(@PathVariable("id") final Long id) {
    bookService.deleteBook(id);
    return "redirect:/books";
  }
}
