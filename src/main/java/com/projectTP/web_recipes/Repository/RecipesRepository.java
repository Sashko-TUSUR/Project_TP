package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Ingredient;
import com.projectTP.web_recipes.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RecipesRepository extends JpaRepository<Recipes, Long>  {


    @Query(value = "SELECT DISTINCT * FROM recipes INNER JOIN recipes_ingredients \n" +
            "           ON recipes.id_recipes = recipes_ingredients.id_recipes JOIN ingredient " +
            "ON recipes_ingredients.id_ingredient = ingredient.id\n" +
            "          WHERE ingredient.id = :id AND recipes.id_type_food = :name",
            nativeQuery = true)
    List<Recipes> findByRecipesIn(@Param("id") Long id,@Param("name") Long name);

/*
     @Query(value = "SELECT DISTINCT name FROM recipes INNER JOIN recipes_ingredients ON recipes.id_recipes = recipes_ingredients.id_recipes\n" +
             "WHERE (recipes_ingredients.id_ingredient)=:veg",
          nativeQuery = true)
    List<Recipes> findByRecipesIn(@Param("veg") Long veg);

     /*
"SELECT DISTINCT name,recipes, comment FROM recipes INNER JOIN recipes_ingredients ON recipes.id_recipes = recipes_ingredients.id_recipes\n" +
        "WHERE (recipes_ingredients.id_ingredient)=2 AND recipes_ingredients.id_recipes IN " +
        "(SELECT DISTINCT recipes_ingredients.id_recipes FROM recipes INNER JOIN recipes_ingredients ON recipes.id_recipes = recipes_ingredients.id_recipes\n" +
        "WHERE ((recipes_ingredients.id_ingredient)=4))",
,@Param("meat") Long meat)
      */

}
