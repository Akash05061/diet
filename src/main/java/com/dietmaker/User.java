package com.dietmaker;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    private Integer age;
    private Double height; // cm
    private Double weight; // kg

    private String profileImageUrl; // S3 URL
}
