package com.projectTP.web_recipes.Controllers;

import com.projectTP.web_recipes.Repository.CommentRepository;
import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/salad")

public class SaladController {

    @Autowired
    private RecipesRepository recipesRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CommentRepository commentRepository;


    //здесь должны возвращаться рецепты после выбора продуктов(динамический запрос надо сделать)
    @PostMapping("/recipes")
    public ResponseEntity<?> Recipes(@RequestParam List<String> ingredient)
    {
        Set<String> ingredients = new HashSet<>(ingredient);
        recipesRepository.findByIngredientIn(ingredients);
        return null;
    }

     //сам рецепт и комментарии к нему
    @GetMapping("/recipe/{name}")
    public ResponseEntity<?> Recipe(@PathVariable(value = "name") String name,Model model){
        recipesRepository.findByName(name);
        model.addAttribute("comment",commentRepository.findAll());
        return null;
    }
    // добавление отзыва
    @PostMapping("/recipe/{name}")
    public ResponseEntity<?> CommentAdd(@RequestParam String comment,@PathVariable(value = "name") String name){
        recipesRepository.findByName(name);
        Comment com = new Comment(comment);
        commentRepository.save(com);
        return null;
    }
}
