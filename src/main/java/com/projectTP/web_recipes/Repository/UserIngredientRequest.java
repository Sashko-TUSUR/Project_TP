package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Ingredient;

import java.util.List;
import java.util.Set;

public interface UserIngredientRequest {
    List<Ingredient> findIngredientsIn(Set<String> ingredients);
}
