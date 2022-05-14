package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipesRepository extends JpaRepository<Recipes, Long> {
    List<Recipes> findByName(String name);
}
