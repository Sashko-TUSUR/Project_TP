package com.projectTP.web_recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "id_typeFood")
    private TypeFood typeFood;

    @ManyToMany
    @JoinTable(name = "recipes_ingredients", joinColumns = @JoinColumn(name = "recipes_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
    @JsonIgnore
            private List<Ingredient> ingredients;

    public Recipes(String recipe, String name, String ingredients, String typeFood, String measureUnit, float quantity) {
    }


}
