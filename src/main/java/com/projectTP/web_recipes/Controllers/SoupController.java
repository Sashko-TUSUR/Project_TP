package com.projectTP.web_recipes.Controllers;

import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.model.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@RequestMapping("/soup")
public class SoupController {
        @Autowired
        private RecipesRepository recipesRepository;


        @GetMapping("/ingredient")
        public String Window()
        {
            return null;
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
