package com.projectTP.web_recipes.Controllers;


import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.model.Ingredient;
import com.projectTP.web_recipes.model.Recipes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

public class NavigationController {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipesRepository recipesRepository;

        @GetMapping("/greeting")
        public String ChoiceIngredient(String ingredient, Model model) {


            model.addAttribute("meat", ingredientRepository.findByMeat());
            model.addAttribute("vegetable", ingredientRepository.findByVegetable());
            model.addAttribute("other", ingredientRepository.findByOther());
            return "greeting";

        }



        //ЗАПРОС НА ПОЛУЧАЕМЫЕ ИНГРИДИЕНТЫ

    @PostMapping("/greeting")
    public String ChoiceIngredient(@RequestParam (required = false) List<String> ingredient,Model model)
    {
        return null;
    }

    @GetMapping("/hello")
    public ResponseEntity<?>helloPage(){
        return null;
    }


 /*

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    */


    @PostMapping("/main")
    public ResponseEntity<?> mainPage(){
        return null;
    }

    @GetMapping("/auth")
    public ResponseEntity<?> Authorization(){
        return null;
    }




    @GetMapping("/recipeAdd")
    public ResponseEntity<?> RecipeAdd(Model model)
    {
        model.addAttribute("ingredient",ingredientRepository.findAll());
        return null;
    }

    //добавление рецепта
    @PostMapping("/recipeAdd")
    public ResponseEntity<?> RecipeAdd
            (@RequestParam String recipes,@RequestParam String name, @RequestParam String ingredient,
            @RequestParam String typeFood, @RequestParam String measureUnit,@RequestParam float quantity)
    {
        Recipes recipes1 = new Recipes(recipes,name,ingredient,typeFood,measureUnit,quantity);
        recipesRepository.save(recipes1);
        return null;
    }





}
