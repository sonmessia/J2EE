package com.example.demo.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Price must not be null")
  @Min(value = 1, message = "Price must be greater than 0")
  @Max(value = 9999999, message = "Price must be less than 10 million")
  @Column(name = "price", nullable = false)
  private Double price;

  @NotBlank(message = "Product name must not be blank")
  @Column(name = "product_name", nullable = false, length = 100)
  private String name;

  @Length(max = 500, message = "Description must be less than 500 characters")
  @Column(length = 200)
  private String image;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  public void setId(int id2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setId'");
  }
}
