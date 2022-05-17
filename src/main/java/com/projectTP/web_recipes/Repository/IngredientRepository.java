package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface IngredientRepository extends JpaRepository<Ingredient, Long> {



  @Query(value = "SELECT * from Ingredient u WHERE u.type = 'мясо'",
            nativeQuery = true)
    List<Ingredient> findByMeat();

    @Query(value = "SELECT * from Ingredient u WHERE u.type = 'овощь'",
            nativeQuery = true)
    List<Ingredient> findByVegetable();

    @Query(value = "SELECT * from Ingredient u WHERE u.type = 'другое'",
            nativeQuery = true)
    List<Ingredient> findByOther();



}
