package com.dietmaker.service;

import com.dietmaker.entity.Food;
import com.dietmaker.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    // Process input like "100g chicken"
    public FoodResult calculateFood(String input) {

        input = input.toLowerCase(Locale.ROOT).trim();

        // 1. Extract weight (default 100g)
        int grams = extractGrams(input);

        // 2. Extract food name (e.g., chicken)
        String foodName = extractFoodName(input);

        // 3. Fetch from DB
        Food food = foodRepository.findByNameIgnoreCase(foodName)
                .orElseThrow(() -> new RuntimeException("Food not found: " + foodName));

        // 4. Calculate macros based on grams
        double factor = grams / 100.0;

        FoodResult result = new FoodResult();
        result.setFoodName(food.getName());
        result.setImageUrl(food.getImageUrl());
        result.setGrams(grams);
        result.setCalories(food.getCalories() * factor);
        result.setProtein(food.getProtein() * factor);
        result.setCarbs(food.getCarbs() * factor);
        result.setFat(food.getFat() * factor);

        return result;
    }

    private int extractGrams(String input) {
        try {
            String number = input.replaceAll("[^0-9]", "").trim();
            return Integer.parseInt(number);
        } catch (Exception e) {
            return 100; // default
        }
    }

    private String extractFoodName(String input) {
        return input.replaceAll("[0-9]", "")   // remove numbers
                .replace("g", "")             // remove g
                .replace("grams", "")
                .replace("gram", "")
                .trim();
    }
}
