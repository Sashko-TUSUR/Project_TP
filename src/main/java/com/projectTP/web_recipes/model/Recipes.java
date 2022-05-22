package com.projectTP.web_recipes.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_recipes;

    private String recipes, name, comment;

    private Boolean approved=false;

    private float quantity;
    private String measureUnit;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_typeFood")
    private TypeFood typeFood;

    @ManyToMany
    @JoinTable(name = "comment_recipes", joinColumns = @JoinColumn(name = "id_recipes"),
            inverseJoinColumns = @JoinColumn(name = "id_comment"))
    private Collection<Comment> comments;

    public Recipes(String recipes, String name, String ingredient, String typeFood, String measureUnit, float quantity) {
    }


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

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }


    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public TypeFood getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(TypeFood typeFood) {
        this.typeFood = typeFood;
    }
    
}
