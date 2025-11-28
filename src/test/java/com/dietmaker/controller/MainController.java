package com.dietmaker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MealRepository mealRepo;
    private final DietPlanRepository dietRepo;
    private final UserRepository userRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("meals", mealRepo.findAll());
        model.addAttribute("plans", dietRepo.findAll());
        return "index";
    }
}
