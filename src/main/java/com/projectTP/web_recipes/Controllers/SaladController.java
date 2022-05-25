package com.projectTP.web_recipes.Controllers;

import com.projectTP.web_recipes.Repository.CommentRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.model.Comment;
import com.projectTP.web_recipes.model.Ingredient;
import com.projectTP.web_recipes.model.Recipes;
import com.projectTP.web_recipes.payload.IngredientResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/salad")

public class SaladController {

    private CommentRepository commentRepository;
    private RecipesRepository recipesRepository;
    private IngredientResponse ingredientResponse;
    public SaladController(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    public SaladController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    //принимаю ингридиенты для запроса
    @PostMapping("/recipes")
    @GetMapping
    public List<Ingredient> Recipes(@RequestBody List<String> ingredient)
    {
        Set<String> ingredients = new HashSet<>(ingredient);
        return  recipesRepository.findByIngredientIn(ingredients);

    }

    //сам рецепт
    @GetMapping("/recipe/{id}")
    public Optional<Recipes> Recipe(@PathVariable(value = "id") Long id){
        return recipesRepository.findById(id);
    }

    //добавление отзыва
    @PostMapping("/recipe/{id}")
    public Comment CommentAdd(@RequestBody String comment, @PathVariable(value = "id") Long id){
        recipesRepository.findById(id);
        Comment com = new Comment(comment);
        return commentRepository.save(com);
    }


}
