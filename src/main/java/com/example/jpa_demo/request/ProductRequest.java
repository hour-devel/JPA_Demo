package com.example.jpa_demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {
   private String name;
   private Double price;
   private int qty;
   private String description;
   private Integer categoryId;
}