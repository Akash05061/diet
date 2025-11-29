package com.dietmaker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;              // e.g., Chicken Breast, Egg, Rice
    private Integer calories;         // per 100g
    private Double protein;           // per 100g
    private Double carbs;             // per 100g
    private Double fat;               // per 100g

    private String imageUrl;          // S3 URL
}
