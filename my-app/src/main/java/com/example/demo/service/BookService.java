package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.model.Book;

@Service
public class BookService {
  private List<Book> books = new ArrayList<>();
  private Long nextId = 1L;

  public List<Book> getAllBooks() {
    return books;
  }

  public void addBook(Book book) {
    book.setId(nextId++);
    books.add(book);
  }

  public Optional<Book> getBookById(Long id) {
    return books.stream().filter(book -> book.getId().equals(id)).findFirst();
  }

  public void updateBook(Long id, Book updatedBook) {
    getBookById(id).ifPresent(book -> {
      book.setTitle(updatedBook.getTitle());
      book.setAuthor(updatedBook.getAuthor());
      book.setPrice(updatedBook.getPrice());
    });
  }

  public void deleteBook(Long id) {
    books.removeIf(book -> book.getId().equals(id));
  }
}
