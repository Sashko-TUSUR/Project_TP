package com.projectTP.web_recipes.payload;

import com.projectTP.web_recipes.model.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class RecipeRequest {
    private String name;
    private String recipes;
    private List<Ingredient> ingredientList;


}
