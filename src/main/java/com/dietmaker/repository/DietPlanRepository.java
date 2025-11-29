package com.dietmaker.repository;

import com.dietmaker.entity.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
}
