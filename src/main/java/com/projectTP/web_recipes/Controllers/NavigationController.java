package com.projectTP.web_recipes.Controllers;


import com.projectTP.web_recipes.Repository.IngredientRepository;
import com.projectTP.web_recipes.Repository.RecipesRepository;
import com.projectTP.web_recipes.Service.UserService;
import com.projectTP.web_recipes.model.*;
import com.projectTP.web_recipes.payload.IngredientResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NavigationController {


    private IngredientRepository ingredientRepository;
    private RecipesRepository recipesRepository;

    public NavigationController(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    public NavigationController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping("/ingredients")
    public List<Ingredient> selectMeat() {return ingredientRepository.findByMeat();}


    //добавление рецепта

    @PostMapping("/recipeAdd")
    public Recipes recipeAdd(@RequestBody String recipes,@RequestBody String name, @RequestBody String ingredient,
                             @RequestBody String typeFood, @RequestBody String measureUnit,@RequestBody float quantity)
    {
        Recipes recipes1  = new Recipes(recipes,name,ingredient,typeFood,measureUnit,quantity);
       return recipesRepository.save(recipes1);
    }



    //@GetMapping("/ingredients")
    //public List<Ingredient> selectVegetable(){return ingredientRepository.findByVegetable();}

    /*
    private final MessageRepo messageRepo;

    public NavigationController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    @GetMapping
    public List<Message> list() {
        return messageRepo.findAll();
    }


    @PostMapping
    public Message create(@RequestBody Message message) {
       return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDb,
                          @RequestBody Message message) {
        BeanUtils.copyProperties(message,messageFromDb,"id");

        return messageRepo.save(message);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        {
            messageRepo.delete(message);
        }
    }

     */
}

