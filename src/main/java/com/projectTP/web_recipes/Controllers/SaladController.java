package com.projectTP.web_recipes.Controllers;

import com.projectTP.web_recipes.Repository.CommentRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.Repository.UserRepository;
import com.projectTP.web_recipes.model.Comment;
import com.projectTP.web_recipes.model.Recipes;
import com.projectTP.web_recipes.model.User;
import com.projectTP.web_recipes.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/salad")

public class SaladController {

    @Autowired
    RecipesRepository recipesRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/recipes/{id}")
    public List<Recipes> Recipes(@PathVariable(value = "id")Long id  )
    {
        return recipesRepository.findByRecipesIn(id);
    }


    @GetMapping("/recipe/{id}")
    public Optional<Recipes> Recipe(@PathVariable(value = "id") Long id) {

        return recipesRepository.findById(id);
    }

    @GetMapping("/recipe")
    public List<Comment> RecipeComment(@RequestParam(name = "id") Long id) {

       return commentRepository.findByCommentIn(id);
    }


    //добавление отзыва
    @PostMapping("/recipe/{id}")
    public ResponseEntity<?> CommentAdd(@RequestBody Comment comment, @PathVariable(value = "id") Long id){
        if(comment.getText() == "")
            return new ResponseEntity<>(new ApiResponse(false,"Комментарий не может быть пустым"), HttpStatus.BAD_REQUEST);
        else {
            int x =1;
            User user = userRepository.getById(Long.valueOf(x));
            comment.setUser(user);
            comment.setDate(LocalDateTime.now());
            commentRepository.save(comment);
            commentRepository.flush();
            commentRepository.addCommentRecipes(id,comment.getId_comment());
            return new ResponseEntity<>(new ApiResponse(true, "Комментарий успешно добавлен"), HttpStatus.OK);
        }
    }


}
