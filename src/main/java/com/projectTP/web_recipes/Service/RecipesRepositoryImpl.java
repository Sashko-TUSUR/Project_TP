package com.projectTP.web_recipes.Service;


import com.projectTP.web_recipes.Repository.UserIngredientRequest;
import com.projectTP.web_recipes.model.Ingredient;
import com.projectTP.web_recipes.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RecipesRepositoryImpl implements UserIngredientRequest {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Ingredient> findIngredientsIn(Set<String> ingredients) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingredient> query = cb.createQuery(Ingredient.class);
        Root<Ingredient> ingredient = query.from(Ingredient.class);

        Path<String> ingredientPath = ingredient.get("name");

        List<Predicate> predicates = new ArrayList<>();
        for ( String name : ingredients) {
            predicates.add(cb.like(ingredientPath, name));
        }
        query.select(ingredient)
                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                .getResultList();
    }

}
