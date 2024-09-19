package com.example.jpa_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "category_tb")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private  String description;
}
