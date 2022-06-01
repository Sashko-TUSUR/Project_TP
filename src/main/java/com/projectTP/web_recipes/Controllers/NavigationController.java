package com.projectTP.web_recipes.Controllers;


import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.Service.UserService;
import com.projectTP.web_recipes.model.*;
import com.projectTP.web_recipes.payload.IngredientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @RequestMapping(value = "/recipeAdd", method = { RequestMethod.GET, RequestMethod.POST })
    public Recipes recipeAdd(@RequestParam String recipe,@RequestParam String name, @RequestParam String ingredients,
                             @RequestParam String typeFood, @RequestParam String measureUnit,@RequestParam float quantity)
    {
        Recipes recipes1  = new Recipes(recipe,name,ingredients,typeFood,measureUnit,quantity);
       return recipesRepository.save(recipes1);
    }





}

