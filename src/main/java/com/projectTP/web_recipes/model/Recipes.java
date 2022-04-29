package com.projectTP.web_recipes.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_recipes;

    private String recipes, name, comment;

    private Boolean approved;


    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "id_typeFood")
    private TypeFood typeFood;

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

    public TypeFood getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(TypeFood typeFood) {
        this.typeFood = typeFood;
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

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
