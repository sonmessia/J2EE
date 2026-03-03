package com.example.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor

public class Category {
  private int id;

  @NotBlank(message = "Tên danh mục không được để trống")
  @Length(max = 100, message = "Name cannot exceed 100 characters")
  private String name;

  public Category() {
  }

}
