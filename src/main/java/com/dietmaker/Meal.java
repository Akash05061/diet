package com.dietmaker;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer calories;
    private Double protein;
    private Double carbs;
    private Double fat;

    private String imageUrl; // S3 URL
}
