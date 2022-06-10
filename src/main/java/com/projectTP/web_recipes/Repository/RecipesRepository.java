package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Comment;
import com.projectTP.web_recipes.model.Ingredient;
import com.projectTP.web_recipes.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface RecipesRepository extends JpaRepository<Recipes, Long>  {


    @Query(value = "SELECT DISTINCT * FROM recipes INNER JOIN recipes_ingredients \n" +
            "           ON recipes.id_recipes = recipes_ingredients.id_recipes JOIN ingredient " +
            "ON recipes_ingredients.id_ingredient = ingredient.id\n" +
            "          WHERE ingredient.id = :id AND recipes.id_type_food = 1 ",
            nativeQuery = true)
    List<Recipes> findByRecipesIn(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO recipes_ingredients VALUES (:id_r,:id_in)",
           nativeQuery = true)
  public void addIngredientsRecipes(@Param("id_r") Long id_recipes,@Param("id_in") List<Ingredient> id_ingredient);



}
