package com.projectTP.web_recipes.Controllers;

import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/HotMeal")
public class HotMealController {

    public class SoupController {

        @Autowired
        private RecipesRepository recipesRepository;

        @PostMapping("/recipes")
        public ResponseEntity<?> Recipes(Model model)
        {
            model.addAttribute("HotMeal",recipesRepository.findByHotMeal());
            return null;
        }

        @PostMapping("/recipe/{name}")
        public ResponseEntity<?> Recipe(@PathVariable(value = "name") String name) {
            recipesRepository.findByName(name);
            return null;
        }

    }
}
