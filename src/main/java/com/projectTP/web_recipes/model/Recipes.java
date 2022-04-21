package com.projectTP.web_recipes.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_recipes;

    private String recipes, type_food, name, comment;

    private Long id_ingredient;

    @ManyToMany
    @JoinTable(name = "comment_recipes", joinColumns = @JoinColumn(name = "id_recipes"),
            inverseJoinColumns = @JoinColumn(name = "id_comment"))
    private Collection<Comment> comments;

    public Long getId_recipes() {
        return id_recipes;
    }

    public void setId_recipes(Long id_recipes) {
        this.id_recipes = id_recipes;
    }

    public String getRecipes() {
        return recipes;
    }

    public void setRecipes(String recipes) {
        this.recipes = recipes;
    }

    public String getType_food() {
        return type_food;
    }

    public void setType_food(String type_food) {
        this.type_food = type_food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(Long id_ingredient) {
        this.id_ingredient = id_ingredient;
    }
}
