package com.example.demo.model;

public class Book {
  private Long id;
  private String title;
  private String author;
  private Long price;

  public Book() {
    this.id = 0L;
    this.title = "Untitled";
    this.author = "Unknown";
    this.price = 0L;
  }

  // Constructor
  public Book(Long id, String title, String author, Long price) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.price = price;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }
}
