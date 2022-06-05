package com.projectTP.web_recipes.Controllers;

import com.projectTP.web_recipes.Repository.CommentRepository;
import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.model.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salad")

public class SaladController {

    @Autowired
    RecipesRepository recipesRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    CommentRepository commentRepository;

    public SaladController() {
    }

    //принимаю ингридиенты для запроса

/*
    @GetMapping("/recipes/list")
    public List<Recipes> Recipes(@RequestParam(required = false) String name) {
        return recipesRepository.findByRecipesIn(name);
    }

 */

    @GetMapping("/recipes/{id}")
    public List<Recipes> Recipes(@PathVariable(name = "id") Long id,@RequestParam(defaultValue = "1") Long name)
    {

        return recipesRepository.findByRecipesIn(id,name);
    }


    /*
    @GetMapping("/recipes/{id}")
    public List<Recipes> Recipes(@PathVariable(value = "id")Long id  )
    {
        return recipesRepository.findByRecipesIn(id);
    }

     */

    @GetMapping("/recipe/{id}")
    public Optional<Recipes> Recipe(@PathVariable(value = "id") Long id) {
        return recipesRepository.findById(id);
    }


/*
    //добавление отзыва
    @PostMapping("/recipe/{id}")
    public Comment CommentAdd(@RequestBody String comment, @PathVariable(value = "id") Long id){
        recipesRepository.findById(id);
        Comment com = new Comment(comment);
        return commentRepository.save(com);
    }

 */


}
