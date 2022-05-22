package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Ingredient;

import java.util.List;
import java.util.Set;

public interface RecipesRepositoryRequest {
    List<Ingredient> findByIngredientIn(Set<String> ingredients);
}
