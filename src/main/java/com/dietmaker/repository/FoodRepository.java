package com.dietmaker.repository;

import com.dietmaker.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    // Find a food by name (case insensitive)
    Optional<Food> findByNameIgnoreCase(String name);
}
