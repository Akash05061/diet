package com.dietmaker.controller;

import com.dietmaker.service.FoodResult;
import com.dietmaker.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class FoodSearchController {

    private final FoodService foodService;

    @GetMapping("/food/search")
    public String showSearchPage() {
        return "food-search";
    }

    @PostMapping("/food/search")
    public String processFoodSearch(@RequestParam String input, Model model) {
        try {
            FoodResult result = foodService.calculateFood(input);
            model.addAttribute("result", result);
            return "food-result";

        } catch (Exception e) {
            model.addAttribute("error", "Food not found. Please try again.");
            return "food-search";
        }
    }
}
