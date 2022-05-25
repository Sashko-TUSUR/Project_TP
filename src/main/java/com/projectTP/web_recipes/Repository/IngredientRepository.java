package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {


    @Query(value = "SELECT *FROM Ingredient",
    nativeQuery = true)
    List<Ingredient> findByMeat();

    @Query(value = "SELECT * FROM Ingredient WHERE type = 'овощь'",
            nativeQuery = true)
    List<Ingredient> findByVegetable();

    @Query(value = "SELECT * FROM Ingredient WHERE type = 'другое'",
            nativeQuery = true)
    List<Ingredient> findByOther();



}