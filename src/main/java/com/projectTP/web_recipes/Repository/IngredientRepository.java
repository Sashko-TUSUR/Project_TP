package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient>findByType(String type);

     @Query(value = "SELECT * FROM Ingredient ",
    nativeQuery = true)
    List<Ingredient> findByMeat();


}