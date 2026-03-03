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

public class Product {
  private int id;
  @NotBlank(message = "Tên sản phẩm không được để trống")
  @Length(max = 100, message = "Name cannot exceed 100 characters")
  private String name;

  @NotNull(message = "Giá không được để trống")
  @Min(value = 1, message = "Quantity must be greater than or equal to 0")
  @Max(value = 999999999, message = "Quantity must be less than or equal to 999999999")
  private Double price;
  @Length(max = 200, message = "Tên hình ảnh không quá 200 ký tự")
  private String image;

  private Category category;
}
