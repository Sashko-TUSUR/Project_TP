package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecipesRepository extends JpaRepository<Recipes, Long>, RecipesRepositoryRequest {


    //все рецепты
   @Query(value = "Select * From Recipes u WHERE u.typeFood ='салат'",
           nativeQuery = true)
    List<Recipes> findBySalad();

    @Query(value = "Select * From Recipes u WHERE u.typeFood ='горячее'",
    nativeQuery = true)
    List<Recipes> findByHotMeal();

    @Query(value = "Select * From Recipes u WHERE u.typeFood ='суп'",
            nativeQuery = true)
    List<Recipes> findBySoup();

}
