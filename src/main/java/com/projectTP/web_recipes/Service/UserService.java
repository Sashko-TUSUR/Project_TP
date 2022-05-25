package com.projectTP.web_recipes.Service;
import com.projectTP.web_recipes.payload.*;
import com.projectTP.web_recipes.Repository.*;
import com.projectTP.web_recipes.model.Ingredient;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private IngredientRepository ingredientRepository;

    public UserService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> selectMeat()
    {
        return ingredientRepository.findByMeat();
    }



}
