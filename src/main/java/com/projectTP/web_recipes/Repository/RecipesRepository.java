package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepository extends JpaRepository<Recipes, Long> {
}
