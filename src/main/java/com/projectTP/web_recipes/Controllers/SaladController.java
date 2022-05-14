package com.projectTP.web_recipes.Controllers;

import com.projectTP.web_recipes.Repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/salad")
@Controller
public class SaladController {

    @Autowired
    private RecipesRepository recipesRepository;



    @GetMapping("/ingredient")
    public String ChoiceIngredient(@RequestParam List<String> ingredient){
            System.out.println("hello" + ingredient);
            return "вы выбрали следующие ингридиенты" + ingredient;

    }

    @PostMapping("/recipes")
    public String Recipes() {
        return null;
    }

    @PostMapping("/recipe/{name}")
    public String Recipe(@PathVariable(value = "name") String name) {
        recipesRepository.findByName(name);
        return null;
    }
}
