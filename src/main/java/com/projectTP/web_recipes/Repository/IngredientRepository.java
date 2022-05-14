package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
