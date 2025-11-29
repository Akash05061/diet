package com.dietmaker.service;

import lombok.Data;

@Data
public class FoodResult {
    private String foodName;
    private int grams;
    private double calories;
    private double protein;
    private double carbs;
    private double fat;
    private String imageUrl;
}
