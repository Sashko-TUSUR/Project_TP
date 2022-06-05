package com.projectTP.web_recipes.Controllers;


import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.model.*;
import com.projectTP.web_recipes.payload.RecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projectTP.web_recipes.payload.ApiResponse;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NavigationController {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipesRepository recipesRepository;


    @GetMapping("/ingredients")
    public List<Ingredient> selectMeat()
        {return ingredientRepository.findByMeat();}


//добавление рецепта
/*
    @PostMapping("/recipe/add")
    public ResponseEntity<?> recipeAdd(@Valid @RequestBody RecipeRequest recipeRequest)
    {
        String Name = recipeRequest.getName();
        Recipes recipes = new Recipes(Name);
        recipesRepository.save(recipes);
        return ResponseEntity.ok(new ApiResponse(true, "Рецепт добавлен"));
    }
    
 */

}

