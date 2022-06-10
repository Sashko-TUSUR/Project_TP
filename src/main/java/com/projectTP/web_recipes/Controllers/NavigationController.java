package com.projectTP.web_recipes.Controllers;


import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.Repository.TypeFoodRepository;
import com.projectTP.web_recipes.Repository.UserRepository;
import com.projectTP.web_recipes.model.*;
import com.projectTP.web_recipes.payload.RecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projectTP.web_recipes.payload.ApiResponse;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class NavigationController {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private TypeFoodRepository typeFoodRepository;
    @Autowired
    private UserRepository userRepository;
    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/ingredients")
    public List<Ingredient> selectMeat()
        {return ingredientRepository.findByMeat();}


//добавление рецепта

    @GetMapping("/recipe/add")
    public List<TypeFood> recipeType()
    {
        return typeFoodRepository.findAll();
    }

    @PostMapping("/recipe/add")
    public ResponseEntity<?> recipeAdd(@RequestBody Recipes recipes )
    {
        int x =1;
        User user = userRepository.getById(Long.valueOf(x));
        recipes.setUser(user);
        recipesRepository.save(recipes);
        return ResponseEntity.ok(new ApiResponse(true, "Рецепт добавлен"));
    }
    


}
