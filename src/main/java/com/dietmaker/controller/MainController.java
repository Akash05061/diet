package com.dietmaker.controller;

import com.dietmaker.repository.DietPlanRepository;
import com.dietmaker.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MealRepository mealRepository;
    private final DietPlanRepository dietPlanRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("meals", mealRepository.findAll());
        model.addAttribute("plans", dietPlanRepository.findAll());
        return "index";
    }
}
