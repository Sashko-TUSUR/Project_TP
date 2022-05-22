package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {



    @Query(value = "SELECT s.name FROM Ingredient s WHERE s.type = 'мясо'")
    List<Ingredient> findByMeat();

    @Query(value = "SELECT s.name FROM Ingredient s WHERE s.type = 'овощь'")
    List<Ingredient> findByVegetable();

    @Query(value = "SELECT s.name FROM Ingredient s WHERE s.type = 'другое'")
    List<Ingredient> findByOther();


}