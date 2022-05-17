package com.projectTP.web_recipes.Controllers;

import com.projectTP.web_recipes.Repository.CommentRepository;
import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/salad")
@Controller
public class SaladController {

    @Autowired
    private RecipesRepository recipesRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CommentRepository commentRepository;


    //здесь должны возвращаться рецепты после выбора продуктов
    @PostMapping("/recipes")
    public ResponseEntity<?> Recipes(Model model)
    {
        model.addAttribute("Salad",recipesRepository.findBySalad());
        return null;
    }

    //сам рецепт и комментарии к нему(динамический запрос надо сделать)
    @GetMapping("/recipe/{name}")
    public ResponseEntity<?> Recipe(@PathVariable(value = "name") String name,Model model){
        recipesRepository.findByName(name);
        model.addAttribute("comment",commentRepository.findAll());
        return null;
    }
    // добавление отзыва
    @PostMapping("/recipe/{name}")
    public ResponseEntity<?> CommentAdd(@RequestParam String comment){
        Comment com = new Comment(comment);
        commentRepository.save(com);
        return null;
    }
}
